package com.dhtinh.demo.service;

import java.util.List;

import com.dhtinh.demo.dto.ResearchingProjectDTO;

public interface ResearchingProjectService {
    public ResearchingProjectDTO getResearchingProject(Long id);
    public List<ResearchingProjectDTO> getResearchingProjects();
    public ResearchingProjectDTO createResearchingProject(ResearchingProjectDTO researchingProjectDTO);
    public ResearchingProjectDTO updateResearchingProject(Long id, ResearchingProjectDTO researchingProjectDTO);
    public void deleteResearchingProject(Long id);
}
