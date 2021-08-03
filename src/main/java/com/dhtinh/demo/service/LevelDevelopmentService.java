package com.dhtinh.demo.service;

import java.util.List;

import com.dhtinh.demo.dto.LevelDevelopmentDTO;

public interface LevelDevelopmentService {
    public LevelDevelopmentDTO getLevelDevelopment(Long id);
    public List<LevelDevelopmentDTO> getLevelDevelopments();
    public LevelDevelopmentDTO createLevelDevelopment(LevelDevelopmentDTO levelDevelopmentDTO);
    public LevelDevelopmentDTO updateLevelDevelopment(Long id, LevelDevelopmentDTO levelDevelopmentDTO);
    public void deleteLevelDevelopment(Long id);
}
