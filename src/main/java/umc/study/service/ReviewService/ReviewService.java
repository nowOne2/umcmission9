package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.dto.reviewDto.ReviewRequestDto;
import umc.study.repository.MemberRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    public void saveReview(ReviewRequestDto reviewRequestDto){
        Store store = storeRepository.findById(reviewRequestDto.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("가게가 존재하지 않습니다"));

        Member member = memberRepository.findById(reviewRequestDto.getMemberId())
                .orElseThrow(()->new IllegalArgumentException("회원이 존재하지 않습니다"));

        Review review = ReviewConverter.toEntity(reviewRequestDto, member, store);

        reviewRepository.save(review);

    }

}
