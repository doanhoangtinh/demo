package com.dhtinh.demo.service.impl;

import java.util.List;

import com.dhtinh.demo.dto.CommercialProjectDTO;
import com.dhtinh.demo.dto.StatusDTO;
import com.dhtinh.demo.dto.UserProfileDTO;
import com.dhtinh.demo.entity.CommercialProject;
import com.dhtinh.demo.entity.Status;
import com.dhtinh.demo.entity.UserProfile;
import com.dhtinh.demo.repository.CommercialProjectRepository;
import com.dhtinh.demo.service.CommercialProjectService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommercialProjectServiceImpl implements CommercialProjectService {
    @Autowired
    private CommercialProjectRepository commercialProjectRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public CommercialProjectDTO createCommercialProject(CommercialProjectDTO commercialProjectDTO) {
        CommercialProject commercialProject = new CommercialProject();
        mapper.map(commercialProjectDTO, commercialProject);
        CommercialProject commercialProjectCreated = commercialProjectRepository.save(commercialProject);
        if(commercialProjectCreated != null){
            CommercialProjectDTO returnValue = new CommercialProjectDTO();
            mapper.map(commercialProjectCreated, returnValue);
            return returnValue;
        }
		return null;
    }

    @Override
    public void deleteCommercialProject(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public CommercialProjectDTO getCommercialProject(Long id) {
        CommercialProject commercialProject = commercialProjectRepository.findOneById(id);
        if(commercialProject != null){
            CommercialProjectDTO returnValue = new CommercialProjectDTO();
            mapper.map(commercialProject, returnValue);
            return returnValue;
        }
        return null;
    }

    @Override
    public List<CommercialProjectDTO> getCommercialProjects() {
        List<CommercialProject> commercialProjects = commercialProjectRepository.findAll();
        if(commercialProjects.size()>0){
            List<CommercialProjectDTO> returnValue = mapper.map(commercialProjects, new TypeToken<List<CommercialProjectDTO>>(){}.getType());
            return returnValue;
        }
        return null;
    }

    @Override
    public CommercialProjectDTO updateCommercialProject(Long id, CommercialProjectDTO commercialProjectDTO) {
        CommercialProject commercialProject = commercialProjectRepository.findOneById(id);
        mapper.map(commercialProjectDTO, commercialProject);
        commercialProject.setId(id);
        
        CommercialProject commercialProjectCreated = commercialProjectRepository.save(commercialProject);
        if(commercialProjectCreated != null){
            CommercialProjectDTO returnValue = new CommercialProjectDTO();
            mapper.map(commercialProjectCreated, returnValue);
            return returnValue;
        }
		return null;
    }

    @Override
    public List<CommercialProjectDTO> getCommercialProjects(UserProfileDTO userProfileDTO, StatusDTO StatusDTO) {
        UserProfile userProfile = new UserProfile();
        mapper.map(userProfileDTO, userProfile);
        Status status = new Status();
        mapper.map(StatusDTO, status);
        List<CommercialProject> commercialProjects = commercialProjectRepository.findByUserAndStatus(userProfile, status);
        if(commercialProjects.size()>0){
            List<CommercialProjectDTO> returnValue = mapper.map(commercialProjects, new TypeToken<List<CommercialProjectDTO>>(){}.getType());
            return returnValue;
        }
        return null;
    }
    
}
