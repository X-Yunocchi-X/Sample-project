package com.project.hitwh.service;

import java.util.List;

import com.project.hitwh.entity.Review;

public interface ReviewService {

    Review getReviewById(String id);
    
    List<Review> getAllReviews();
    
    int insertReview(Review review);
}
