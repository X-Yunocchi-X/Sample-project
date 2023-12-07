package com.project.hitwh.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hitwh.entity.Review;
import com.project.hitwh.mapper.ReviewMapper;
import com.project.hitwh.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    ReviewMapper reviewMapper;
    
    @Override
    public Review getReviewById(String id) {
        return reviewMapper.getReviewById(id);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewMapper.getAllReviews();
    }

    @Override
    public int insertReview(Review review) {
        return reviewMapper.insertReview(review);
    }

}
