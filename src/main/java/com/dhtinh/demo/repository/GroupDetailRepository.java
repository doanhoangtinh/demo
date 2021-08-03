package com.dhtinh.demo.repository;

import com.dhtinh.demo.entity.GroupDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GroupDetailRepository extends JpaRepository<GroupDetail, Long> {
    
}
