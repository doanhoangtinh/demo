package com.dhtinh.demo.service;

import java.util.List;

import com.dhtinh.demo.dto.CommercialProjectDTO;
import com.dhtinh.demo.dto.StatusDTO;
import com.dhtinh.demo.dto.UserProfileDTO;

public interface CommercialProjectService {
    public CommercialProjectDTO getCommercialProject(Long id);
    public List<CommercialProjectDTO> getCommercialProjects();
    public List<CommercialProjectDTO> getCommercialProjects(UserProfileDTO userProfileDTO, StatusDTO statusDTO);
    public List<CommercialProjectDTO> getCommercialProjects(StatusDTO statusDTO);
    public CommercialProjectDTO createCommercialProject(CommercialProjectDTO commercialProjectDTO);
    public CommercialProjectDTO updateCommercialProject(Long id, CommercialProjectDTO commercialProjectDTO);
    public void deleteCommercialProject(Long id);
    public void deleteCommercialProjects();
}
