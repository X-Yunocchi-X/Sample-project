package com.project.hitwh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.project.hitwh.entity.Review;

@Mapper
public interface ReviewMapper {

    @Select("select * from Reviews where ReviewID = #{id}")
    Review getReviewById(String id);
    
    @Select("select * from Reviews")
    List<Review> getAllReviews();
    
    @Insert("insert into Reviews(ReviewText, courseID, studentID) values(#{reviewText}, #{courseID}, #{studentID}")
    int insertReview(Review review);
    
}
