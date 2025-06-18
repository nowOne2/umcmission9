package umc.study.service.MemberService;
import umc.study.domain.Member;
import umc.study.dto.loginDto.LoginRequestDto;
import umc.study.dto.loginDto.LoginResultDto;
import umc.study.dto.memberDTO.MemberRequestDto;


public interface MemberCommandService {
    Member joinMember(MemberRequestDto.JoinDto request);
    LoginResultDto loginMember(LoginRequestDto request);
}
