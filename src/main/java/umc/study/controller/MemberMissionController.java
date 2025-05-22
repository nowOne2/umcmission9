package umc.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.domain.mapping.MemberMission;
import umc.study.dto.memberMissionDto.MemberMissionRequestDto;
import umc.study.dto.reviewDto.ReviewRequestDto;
import umc.study.service.MemberMissionService.MemberMissionService;
import umc.study.service.MemberService.MemberQueryService;

@RequiredArgsConstructor
@RestController
public class MemberMissionController {

    private final MemberMissionService memberMissionService;

    @PostMapping("/mission/member/register")
    public ApiResponse<Void> createMemberMission(@Valid @RequestBody MemberMissionRequestDto requestDto){
        memberMissionService.saveMemberMission(requestDto);
        return ApiResponse.onSuccess(null);
    }

}
