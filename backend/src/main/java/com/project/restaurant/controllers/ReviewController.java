package com.project.restaurant.controllers;

import com.project.restaurant.domain.ReviewCreateUpdateRequest;
import com.project.restaurant.domain.dtos.ReviewCreateUpdateDto;
import com.project.restaurant.domain.dtos.ReviewDto;
import com.project.restaurant.domain.entities.Review;
import com.project.restaurant.domain.entities.User;
import com.project.restaurant.mappers.ReviewMapper;
import com.project.restaurant.services.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    @PostMapping
    public ResponseEntity<ReviewDto> postReview(@PathVariable String restaurantId,
                                                @Valid @RequestBody ReviewCreateUpdateDto dto,
                                                @AuthenticationPrincipal Jwt jwt) {
        ReviewCreateUpdateRequest request = reviewMapper.toReviewCreateUpdateRequest(dto);

        User user = jwtToUser(jwt);

        Review createdReview = reviewService.createReview(user, restaurantId, request);

        return ResponseEntity.ok(reviewMapper.toReviewDto(createdReview));
    }

    @GetMapping
    public Page<ReviewDto> listReview(@PathVariable String restaurantId,
                                      @PageableDefault(size = 20, page = 0, sort = "datePosted",
                                              direction = Sort.Direction.DESC) Pageable pageable) {
        return reviewService.listRestaurantReviews(restaurantId, pageable)
                .map(reviewMapper::toReviewDto);
    }

    @GetMapping("{reviewId}")
    public ResponseEntity<ReviewDto> getRestaurantReview(@PathVariable String restaurantId,
                                                         @PathVariable String reviewId) {
        return reviewService.getRestaurantReview(restaurantId, reviewId)
                .map(reviewMapper::toReviewDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PutMapping("{reviewId}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable String restaurantId,
                                                  @PathVariable String reviewId,
                                                  @RequestBody ReviewCreateUpdateDto dto,
                                                  @AuthenticationPrincipal Jwt jwt) {
        ReviewCreateUpdateRequest request = reviewMapper.toReviewCreateUpdateRequest(dto);

        User user = jwtToUser(jwt);

        Review updatedReview = reviewService.updateReview(
                user,
                restaurantId,
                reviewId,
                request);

        return ResponseEntity.ok(reviewMapper.toReviewDto(updatedReview));
    }

    @DeleteMapping("{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable String restaurantId,
                                             @PathVariable String reviewId) {
        reviewService.deleteReview(restaurantId, reviewId);
        return ResponseEntity.noContent().build();
    }

    private User jwtToUser(Jwt jwt) {
        return new User(
                jwt.getSubject(),
                jwt.getClaimAsString("preferred_username"),
                jwt.getClaimAsString("first_name"),
                jwt.getClaimAsString("last_name")
        );
    }


}
