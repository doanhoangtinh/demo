package com.dhtinh.demo.repository;

import com.dhtinh.demo.entity.CommercialProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommercialProjectRepository extends JpaRepository<CommercialProject,Long> {
    
}
