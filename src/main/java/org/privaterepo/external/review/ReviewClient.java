package org.privaterepo.external.review;


import org.privaterepo.configuration.FeignConfiguration;
import org.privaterepo.dto.ApplicationResponseDto;
import org.privaterepo.external.review.dto.ProfileReviewResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "reviewClient", url = "https://mapi.oliveyoung.co.kr/review/api", configuration = FeignConfiguration.class)
public interface ReviewClient {

    @GetMapping(value = "/v1/profile/{profileKey}/review")
    ApplicationResponseDto<ProfileReviewResponseDto> getReviews(
            @PathVariable("profileKey") String profileKey,
            @RequestParam("pageSize") int pageSize
    );

    @PostMapping(value = "/v1/goods/review/{reviewId}/recommend")
    void recommend(@PathVariable("reviewId") String reviewId,
                   @RequestHeader("Authorization") String token);

    @GetMapping(value = "/v1/goods/detail/relate-goods/{goodsNumber}/legacy-goods-number")
    ApplicationResponseDto<String> getLegacyCode(@PathVariable("goodsNumber") String goodsNumber);

}
