package com.dhtinh.demo.repository;

import com.dhtinh.demo.entity.FileInfomation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileInfomationRepository extends JpaRepository<FileInfomation,Long> {
    
}
