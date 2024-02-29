package org.privaterepo.external.review.dto;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class ProfileReviewResponseDto {

    private List<ReviewDto> reviewList = Collections.emptyList();

}
