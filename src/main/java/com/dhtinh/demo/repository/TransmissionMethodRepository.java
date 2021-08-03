package com.dhtinh.demo.repository;

import com.dhtinh.demo.entity.TransmissionMethod;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransmissionMethodRepository extends JpaRepository<TransmissionMethod,Long> {
    
}
