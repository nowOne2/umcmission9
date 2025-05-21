package umc.study.dto.reviewDto;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewRequestDto {
    @NotBlank(message = "제목은 필수 입력 항목입니다.")
    private String title;

    @NotNull(message = "평점은 필수 입력 항목입니다.")
    @DecimalMin(value = "0.0", message = "평점은 0.0 이상이어야 합니다.")
    @DecimalMax(value = "5.0", message = "평점은 5.0 이하여야 합니다.")
    private Float score;

    @NotBlank(message = "리뷰 본문은 필수 입력 항목입니다.")
    private String body;

    @NotNull(message = "회원 ID는 필수 입력 항목입니다.")
    private Long memberId;

    @NotNull(message = "가게 ID는 필수 입력 항목입니다.")
    private Long storeId;
}
