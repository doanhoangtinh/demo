package com.dhtinh.demo.repository;

import com.dhtinh.demo.entity.LevelDevelopment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LevelDevelopmentRepository extends JpaRepository<LevelDevelopment,Long> {
    public LevelDevelopment findOneById(Long id);
}
