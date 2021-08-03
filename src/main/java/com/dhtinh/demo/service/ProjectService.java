package com.dhtinh.demo.service;

import java.util.List;

import com.dhtinh.demo.dto.ProjectDTO;

public interface ProjectService {
    public ProjectDTO getProject(Long id);
    public List<ProjectDTO> getProjects();
    public ProjectDTO createProject(ProjectDTO projectDTO);
    public ProjectDTO updateProject(Long id, ProjectDTO projectDTO);
    public void deleteProject(Long id);
}
