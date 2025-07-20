package com.project.restaurant.mappers;

import com.project.restaurant.domain.ReviewCreateUpdateRequest;
import com.project.restaurant.domain.dtos.ReviewCreateUpdateDto;
import com.project.restaurant.domain.dtos.ReviewDto;
import com.project.restaurant.domain.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewMapper {
    ReviewCreateUpdateRequest toReviewCreateUpdateRequest(ReviewCreateUpdateDto dto);

    ReviewDto toReviewDto(Review review);
}
