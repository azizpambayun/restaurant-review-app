package com.project.restaurant.services;

import com.project.restaurant.domain.ReviewCreateUpdateRequest;
import com.project.restaurant.domain.entities.Review;
import com.project.restaurant.domain.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReviewService {
    Review createReview(User author, String restaurantId, ReviewCreateUpdateRequest review);

    Page<Review> listRestaurantReviews(String restaurantId, Pageable pageable);

    Optional<Review> getRestaurantReview(String restaurantId, String reviewId);

    Review updateReview(User user, String restaurantId, String reviewId, ReviewCreateUpdateRequest request);

    void deleteReview(String restaurantId, String reviewId);
}
