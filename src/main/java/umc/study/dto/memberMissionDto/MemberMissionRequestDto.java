package umc.study.dto.memberMissionDto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberMissionRequestDto {
    @NotBlank(message = "status는 필수 값입니다.")
    private String status;

    @NotNull(message = "memberId는 필수 값입니다.")
    private Long memberId;

    @NotNull(message = "missionId는 필수 값입니다.")
    private Long missionId;

}
