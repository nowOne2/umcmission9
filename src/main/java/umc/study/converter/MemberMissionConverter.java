package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.dto.memberMissionDto.MemberMissionRequestDto;
import umc.study.dto.reviewDto.ReviewRequestDto;

public class MemberMissionConverter {
    public static MemberMission toEntity(MemberMissionRequestDto memberMissionRequestDto, Member member, Mission mission){
        return MemberMission.builder()
                .status(MissionStatus.valueOf(memberMissionRequestDto.getStatus()))
                .member(member)
                .mission(mission)
                .build();

    }
}
