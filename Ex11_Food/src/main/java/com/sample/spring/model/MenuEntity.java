package com.sample.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Table(name = "menu")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long foodId;
    private String name;
    private Integer price;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
