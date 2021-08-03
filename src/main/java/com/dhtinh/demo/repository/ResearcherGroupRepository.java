package com.dhtinh.demo.repository;

import com.dhtinh.demo.entity.ResearcherGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearcherGroupRepository extends JpaRepository<ResearcherGroup,Long>{
    
}
