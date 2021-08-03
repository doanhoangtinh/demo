package com.dhtinh.demo.repository;

import com.dhtinh.demo.entity.RoleOfGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleOfGroupRepository extends JpaRepository<RoleOfGroup,Long>{
    
}
