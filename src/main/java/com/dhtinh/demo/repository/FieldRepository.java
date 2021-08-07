package com.dhtinh.demo.repository;

import com.dhtinh.demo.entity.Field;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends JpaRepository<Field,Long>{
    public Field findOneById(Long id);
}
