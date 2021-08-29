package com.dhtinh.demo.repository;

import java.util.List;

import com.dhtinh.demo.entity.CommercialProject;
import com.dhtinh.demo.entity.Status;
import com.dhtinh.demo.entity.UserProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CommercialProjectRepository extends JpaRepository<CommercialProject,Long> {
    public CommercialProject findOneById(Long id);
    public List<CommercialProject> findByUserAndStatus(UserProfile userProfile, Status status);
    public List<CommercialProject> findByStatus(Status status);
}
