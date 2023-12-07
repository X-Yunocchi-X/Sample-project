package com.project.hitwh.entity;

import java.sql.Date;

public record Review(
    int reviewID,
    String reviewText,
    int courseID,
    int studentID,
    Date reviewDate
) {}
