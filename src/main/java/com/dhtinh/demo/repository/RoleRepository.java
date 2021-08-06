package com.dhtinh.demo.repository;

import java.util.List;

import com.dhtinh.demo.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    public Role findOneById(Long id);
    public List<Role> findAll(); 
}
