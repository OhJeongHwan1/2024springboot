package com.sample.spring.repository;

import com.sample.spring.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity,Long> {
}
