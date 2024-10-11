package com.sample.spring.repository;

import com.sample.spring.model.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity,Long> {
}
