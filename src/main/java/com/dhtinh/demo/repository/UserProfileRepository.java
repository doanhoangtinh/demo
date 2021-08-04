package com.dhtinh.demo.repository;

import com.dhtinh.demo.entity.User;
import com.dhtinh.demo.entity.UserProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long>{
    User findOneById(Long id);
}
