package com.dhtinh.demo.service;

import java.util.List;

import com.dhtinh.demo.dto.CommercialProjectDTO;

public interface CommercialProjectService {
    public CommercialProjectDTO getCommercialProject(Long id);
    public List<CommercialProjectDTO> getCommercialProjects();
    public CommercialProjectDTO createCommercialProject(CommercialProjectDTO commercialProjectDTO);
    public CommercialProjectDTO updateCommercialProject(Long id, CommercialProjectDTO commercialProjectDTO);
    public void deleteCommercialProject(Long id);
}
