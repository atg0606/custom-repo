package org.privaterepo.controller;

import lombok.RequiredArgsConstructor;
import org.privaterepo.constant.Member;
import org.privaterepo.service.ReviewRecommendService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private/api/v1")
@RequiredArgsConstructor
public class ReviewRecommendController {

    private final ReviewRecommendService reviewRecommendService;

    @PostMapping("/review/recommend")
    public String getReviewRecommend(
            @RequestParam Member targetMember,
            @RequestParam Member member,
            @RequestParam(value = "pageSize", required = false, defaultValue = "50") Integer pageSize
    ) {

        return reviewRecommendService.process(
                targetMember,
                member,
                pageSize
        );
    }

}
