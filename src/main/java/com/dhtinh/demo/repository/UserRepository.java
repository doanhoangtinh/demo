package com.dhtinh.demo.repository;

import java.util.List;

import com.dhtinh.demo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findOneByUsernameAndPassword(String username, String password);
    public List<User> findAllByRoleId(Long id);
}
