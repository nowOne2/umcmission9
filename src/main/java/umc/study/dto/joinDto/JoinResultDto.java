package umc.study.dto.joinDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JoinResultDto {
    Long memberId;
    LocalDateTime createdAt;
}
