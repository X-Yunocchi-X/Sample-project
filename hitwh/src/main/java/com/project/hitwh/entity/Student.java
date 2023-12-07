package com.project.hitwh.entity;

public record Student(
    int studentID,
    String name,
    String gender,
    String companyOccupation,
    String techLevel,
    int companyID,
    boolean paymentStatus
) {}
