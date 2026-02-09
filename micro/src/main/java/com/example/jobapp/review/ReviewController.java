package com.example.jobapp.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
         List<Review> reviews = reviewService.getAllReview(companyId);
         return new ResponseEntity<>(reviews, HttpStatus.OK);
     }

     @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId,
                                            @RequestBody Review review) {
       boolean addReview = reviewService.addReview(companyId,review);
        if(addReview)
         return new ResponseEntity<>("Review Added Successfully",HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Review Not saved ",HttpStatus.NOT_FOUND);
     }

     @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,
                                            @PathVariable Long reviewId){
        Review review = reviewService.getReview(companyId,reviewId);
        return new ResponseEntity<>(review,HttpStatus.OK);
     }

     @PutMapping("/review/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,
                                               @RequestBody Review review){
        boolean updateReview = reviewService.updateReview(companyId,reviewId,review);
        if(updateReview)
            return new ResponseEntity<>("Review Updated Successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Review Not Updated",HttpStatus.NOT_FOUND);
     }

    @DeleteMapping("/review/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId){
        boolean deleteReview = reviewService.deleteReview(companyId,reviewId);
        if(deleteReview)
            return new ResponseEntity<>("Review deleted Successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Review Not deleted",HttpStatus.NOT_FOUND);
    }




}
