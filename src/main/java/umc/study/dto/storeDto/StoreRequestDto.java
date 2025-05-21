package umc.study.dto.storeDto;

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
public class StoreRequestDto {
    @NotNull(message = "지역 ID는 필수입니다.")
    private Long region_id;

    @NotBlank(message = "가게 이름은 필수입니다.")
    private String name;


    @NotBlank(message = "주소는 필수입니다.")
    private String address;

    @NotNull(message = "평점은 필수입니다.")
    @DecimalMin(value = "0.0", message = "평점은 0.0 이상이어야 합니다.")
    @DecimalMax(value = "5.0", message = "평점은 5.0 이하여야 합니다.")
    private Float score;
}
