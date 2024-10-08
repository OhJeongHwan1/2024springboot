package com.sample.spring.repository;

import com.sample.spring.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    // CRUD 자동 생성
    Page<Member> findByNameLike(String keyword, Pageable pageable);
}
