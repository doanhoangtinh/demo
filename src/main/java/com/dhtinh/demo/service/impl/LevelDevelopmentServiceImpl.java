package com.dhtinh.demo.service.impl;

import java.util.List;

import com.dhtinh.demo.dto.LevelDevelopmentDTO;
import com.dhtinh.demo.entity.LevelDevelopment;
import com.dhtinh.demo.repository.LevelDevelopmentRepository;
import com.dhtinh.demo.service.LevelDevelopmentService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelDevelopmentServiceImpl implements LevelDevelopmentService{
    @Autowired
    private LevelDevelopmentRepository levelDevelopmentRepository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public LevelDevelopmentDTO createLevelDevelopment(LevelDevelopmentDTO levelDevelopmentDTO) {
        LevelDevelopment levelDevelopment = new LevelDevelopment();
        mapper.map(levelDevelopmentDTO, levelDevelopment);
        LevelDevelopment levelDevelopmentCreated = levelDevelopmentRepository.save(levelDevelopment);
        if(levelDevelopmentCreated != null){
            LevelDevelopmentDTO returnValue = new LevelDevelopmentDTO();
            mapper.map(levelDevelopmentCreated, returnValue);
            return returnValue;
        }
		return null;
    }

    @Override
    public void deleteLevelDevelopment(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public LevelDevelopmentDTO getLevelDevelopment(Long id) {
        LevelDevelopment levelDevelopment = levelDevelopmentRepository.findOneById(id);
        if(levelDevelopment != null){
            LevelDevelopmentDTO returnValue = new LevelDevelopmentDTO();
            mapper.map(levelDevelopment, returnValue);
            return returnValue;
        }
        return null;
    }

    @Override
    public List<LevelDevelopmentDTO> getLevelDevelopments() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LevelDevelopmentDTO updateLevelDevelopment(Long id, LevelDevelopmentDTO levelDevelopmentDTO) {
        // TODO Auto-generated method stub
        return null;
    }

}
