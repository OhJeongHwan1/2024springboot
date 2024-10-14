package com.sample.spring.service;

import com.sample.spring.model.ReviewEntity;
import com.sample.spring.repository.FoodRepository;
import com.sample.spring.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class ReviewService {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Transactional
    public void createReview(Long foodId,String content, Double score){
        foodRepository.findById(foodId).orElseThrow();

        ReviewEntity review = ReviewEntity.builder()
                .foodId(foodId)
                .content(content)
                .score(score)
                .createdAt(ZonedDateTime.now())
                .build();

        reviewRepository.save(review);
    }

    @Transactional
    public void deleteReview(Long reviewId){
        ReviewEntity review = reviewRepository.findById(reviewId).orElseThrow();
        reviewRepository.delete(review);
    }

    public ReviewDto getFoodReview(Long foodId, Pageable page){
        Double avgScore = reviewRepository.getAvgScoreByFoodId(foodId);

        Slice<ReviewEntity> reviews = reviewRepository.findSliceByFoodId(foodId, page);

        return ReviewDto.builder()
                .avgScore(avgScore)
                .reviews(reviews.getContent())
                .page(
                        ReviewDto.ReviewDtoPage.builder()
                                .offset(page.getPageNumber()* page.getPageSize())
                                .limit(page.getPageSize())
                                .build()
                )
                .build();
    }
}
