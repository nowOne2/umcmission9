package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.config.security.jwt.JwtTokenProvider;
import umc.study.converter.MemberConverter;
import umc.study.domain.FoodCategory;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.dto.loginDto.LoginRequestDto;
import umc.study.dto.loginDto.LoginResultDto;
import umc.study.dto.memberDTO.MemberRequestDto;
import umc.study.repository.FoodCategoryRepository;

import java.util.Collections;
import java.util.stream.Collectors;

import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.converter.MemberPreferConverter;
import umc.study.repository.MemberRepository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDto.JoinDto request) {

        if(memberRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new MemberHandler(ErrorStatus.DUPLICATE_JOIN_REQUEST);
        }

        Member newMember = MemberConverter.toMember(request);
        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));

        if (!request.getPreferCategory().isEmpty()) {
            List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                    .map(category -> {
                        return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                    }).collect(Collectors.toList());

            List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

            memberPreferList.forEach(memberPrefer -> {
                memberPrefer.setMember(newMember);
            });

        }
        return memberRepository.save(newMember);
    }

    @Override
    public LoginResultDto loginMember(LoginRequestDto request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if(!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new MemberHandler(ErrorStatus.INVALID_PASSWORD);
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                member.getEmail(), null,
                Collections.singleton(() -> member.getRole().name())
        );

        String accessToken = jwtTokenProvider.generateToken(authentication);

        return MemberConverter.toLoginResultDTO(
                member.getId(),
                accessToken
        );
    }
}
