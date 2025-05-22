package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.dto.memberMissionDto.MemberMissionRequestDto;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberMissionService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    public void saveMemberMission(MemberMissionRequestDto memberMissionRequestDto){
        Member member = memberRepository.findById(memberMissionRequestDto.getMemberId())
                .orElseThrow(()->new IllegalArgumentException("회원이 존재하지 않습니다"));

        Mission mission = missionRepository.findById(memberMissionRequestDto.getMissionId())
                .orElseThrow(()->new IllegalArgumentException("미션이 존재하지 않습니다"));

        MemberMission memberMission = MemberMissionConverter.toEntity(memberMissionRequestDto, member, mission);

        memberMissionRepository.save(memberMission);
    }

}
