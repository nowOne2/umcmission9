package umc.study.converter;

import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.dto.storeDto.StoreRequestDto;

public class StoreConverter {
    public static Store toEntity(StoreRequestDto storeRequestDto, Region region){
        return Store.builder()
                .name(storeRequestDto.getName())
                .address(storeRequestDto.getAddress())
                .score(storeRequestDto.getScore())
                .region(region)
                .build();
    }
}
