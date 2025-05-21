package umc.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.dto.storeDto.StoreRequestDto;
import umc.study.service.StoreService.StoreQueryService;
import umc.study.service.StoreService.StoreQueryServiceImpl;

@RequiredArgsConstructor
@RestController
public class StoreController {
    private final StoreQueryServiceImpl storeQueryService;

    @PostMapping("/store/register")
    public ApiResponse<Void> createItem(@Valid @RequestBody StoreRequestDto requestDto){
        storeQueryService.saveStore(requestDto);
        return ApiResponse.onSuccess(null);
    }

}
