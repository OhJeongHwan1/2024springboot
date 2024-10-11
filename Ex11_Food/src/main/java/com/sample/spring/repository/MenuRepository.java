package com.sample.spring.repository;

import com.sample.spring.model.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity,Long> {
    public List<MenuEntity> findAllByFoodId(Long foodId);
}
