package umc.study.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import umc.study.domain.Member;
import umc.study.dto.memberDTO.MemberInfoDto;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);
    MemberInfoDto getMemberInfo(HttpServletRequest request);

}
