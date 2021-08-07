package com.dhtinh.demo.service.impl;

import java.util.List;

import com.dhtinh.demo.dto.UserProfileDTO;
import com.dhtinh.demo.entity.UserProfile;
import com.dhtinh.demo.repository.UserProfileRepository;
import com.dhtinh.demo.service.UserProfileService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public UserProfileDTO createUserProfile(UserProfileDTO userProfileDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteUserProfile(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public UserProfileDTO getUserProfile(Long id) {
        UserProfile userProfile = userProfileRepository.findOneById(id);
        if(userProfile != null){
            UserProfileDTO returnValue = new UserProfileDTO();
            mapper.map(userProfile, returnValue);
            return returnValue;
        }
        return null;
    }

    @Override
    public List<UserProfileDTO> getUserProfiles() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserProfileDTO updateUserProfile(Long id, UserProfileDTO userProfileDTO) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
