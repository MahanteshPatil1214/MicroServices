package com.example.jobapp.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReview(Long companyId);
    boolean addReview(Long companyId,Review review);
    Review getReview(Long companyId,Long reviewId);
}
