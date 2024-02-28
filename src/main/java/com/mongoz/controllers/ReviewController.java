package com.mongoz.controllers;

import com.mongoz.entities.Review;
import com.mongoz.repositories.Reviewrepositor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("review")
public class ReviewController {

    @Autowired
    private Reviewrepositor reviewrepo;



    @GetMapping("get-all")
    public List<Review> getAllReviews()
    {
        return reviewrepo.findAll();
    }
    @GetMapping("get/{idreview}")
    public void getReviewById(@PathVariable("idreview") Long idreview)
    {
        reviewrepo.findById(idreview);
    }

    @PostMapping("add")
    public Review addReview(@RequestBody Review review)
    {
        return reviewrepo.save(review);
    }

    @PutMapping("update")
    public Review updateReview(@RequestBody Review review)
    {
        return reviewrepo.save(review);
    }

    @DeleteMapping("delete/{idreview}")
    public void deleteReview(@PathVariable("idreview") Long idreview)
    {
        reviewrepo.deleteById(idreview);
    }

}
