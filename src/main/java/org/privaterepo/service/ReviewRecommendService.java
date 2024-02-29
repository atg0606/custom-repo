package org.privaterepo.service;

import feign.Response;
import lombok.RequiredArgsConstructor;
import org.privaterepo.constant.Member;
import org.privaterepo.external.auth.AuthClient;
import org.privaterepo.external.review.ReviewClient;
import org.privaterepo.external.review.dto.ReviewDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewRecommendService {

    private final ReviewClient reviewClient;
    private final AuthClient authClient;

    public String process(Member targetMember, Member member, Integer pageSize) {

        String targetProfile = targetMember.getProfileKey();
        String requestMemberNumber = member.getMemberNumber();

        System.out.println("targetProfile = " + targetProfile + " requestMemberNumber = " + requestMemberNumber + " pageSize = " + pageSize);

        List<String> reviewIds = reviewClient.getReviews(
                targetProfile,
                pageSize
        ).getData().getReviewList().stream().map(ReviewDto::getId).toList();

        Response response = authClient.getToken(requestMemberNumber);
        String token = response.headers().get("authorization").iterator().next();

        reviewIds.forEach(reviewId -> {
            try {
                Thread.sleep(500);
                reviewClient.recommend(reviewId, token);
                System.out.println("reviewId = " + reviewId);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("finish!");
        return "finish!";
    }


}
