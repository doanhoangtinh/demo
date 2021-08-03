package com.dhtinh.demo.repository;

import com.dhtinh.demo.entity.ResearchingProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchingProjectRepository extends JpaRepository<ResearchingProject,Long> {
    
}
