package com.project.hitwh.entity;

import java.sql.Date;

public record Course(
    int courseID,
    String courseName,
    Date startDate,
    int durationDays,
    int instructorID
) {}
