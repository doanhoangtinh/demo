package com.dhtinh.demo.service;

import java.util.List;

import com.dhtinh.demo.dto.ResearcherGroupDTO;

public interface ResearcherGroupService {
    public ResearcherGroupDTO getResearcherGroup(Long id);
    public List<ResearcherGroupDTO> getResearcherGroups();
    public ResearcherGroupDTO createResearcherGroup(ResearcherGroupDTO researcherGroupDTO);
    public ResearcherGroupDTO updateResearcherGroup(Long id, ResearcherGroupDTO researcherGroupDTO);
    public void deleteResearcherGroup(Long id);
}
