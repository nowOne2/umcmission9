package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.enums.Gender;
import umc.study.dto.joinDto.JoinResultDto;
import umc.study.dto.loginDto.LoginResultDto;
import umc.study.dto.memberDTO.MemberInfoDto;
import umc.study.dto.memberDTO.MemberRequestDto;
import umc.study.dto.memberDTO.MemberResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {
    public static JoinResultDto toJoinResultDTO(Member member){
        return JoinResultDto.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDto.JoinDto request) {
        Gender gender = null;
        switch (request.getGender()) {
            case 1: gender = Gender.MALE; break;
            case 2: gender = Gender.FEMALE; break;
            case 3: gender = Gender.NONE; break;
        }

        return Member.builder()
                .name(request.getName())
                .email(request.getEmail())   // 추가된 코드
                .password(request.getPassword())   // 추가된 코드
                .gender(gender)
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .role(request.getRole())   // 추가된 코드
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static LoginResultDto toLoginResultDTO(Long memberId, String accessToken) {
        return LoginResultDto.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .build();
    }

    public static MemberInfoDto toMemberInfoDTO(Member member){
        return MemberInfoDto.builder()
                .name(member.getName())
                .email(member.getEmail())
                .gender(member.getGender().name())
                .build();
    }
}
