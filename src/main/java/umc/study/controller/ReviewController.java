package umc.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.dto.reviewDto.ReviewRequestDto;
import umc.study.dto.storeDto.StoreRequestDto;
import umc.study.service.ReviewService.ReviewService;
import umc.study.service.StoreService.StoreQueryServiceImpl;
@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/review/register")
    public ApiResponse<Void> createReview(@Valid @RequestBody ReviewRequestDto requestDto){
        reviewService.saveReview(requestDto);
        return ApiResponse.onSuccess(null);
    }

    }

