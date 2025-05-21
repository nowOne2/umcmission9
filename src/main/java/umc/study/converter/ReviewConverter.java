package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Region;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.dto.reviewDto.ReviewRequestDto;
import umc.study.dto.storeDto.StoreRequestDto;

public class ReviewConverter {
    public static Review toEntity(ReviewRequestDto reviewRequestDto, Member member, Store store){
        return Review.builder()
                .title(reviewRequestDto.getTitle())
                .score(reviewRequestDto.getScore())
                .body(reviewRequestDto.getBody())
                .member(member)
                .store(store)
                .build();
    }
}
