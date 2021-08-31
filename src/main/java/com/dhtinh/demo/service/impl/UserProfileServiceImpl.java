package com.dhtinh.demo.service.impl;

import java.util.List;

import com.dhtinh.demo.dto.UserProfileDTO;
import com.dhtinh.demo.entity.UserProfile;
import com.dhtinh.demo.repository.UserProfileRepository;
import com.dhtinh.demo.service.UserProfileService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
        UserProfile userProfile = new UserProfile();
        mapper.map(userProfileDTO, userProfile);
        UserProfile userProfileCreated = userProfileRepository.save(userProfile);
        if(userProfileCreated != null){
            UserProfileDTO returnValue = new UserProfileDTO();
            mapper.map(userProfileCreated, returnValue);
            return returnValue;
        }
        return null;
    }

    @Override
    public void deleteUserProfile(Long id) {
        userProfileRepository.delete(userProfileRepository.findOneById(id));
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
        List<UserProfile> userProfiles = userProfileRepository.findAll();
        if(userProfiles.size() > 0){
            List<UserProfileDTO> returnValue = mapper.map(userProfiles, new TypeToken<List<UserProfileDTO>>(){}.getType());
            return returnValue;
        }
        return null;
    }

    @Override
    public UserProfileDTO updateUserProfile(Long id, UserProfileDTO userProfileDTO) {
        mapper.typeMap(UserProfileDTO.class, UserProfile.class).addMappings(mapper -> {
            mapper.skip(UserProfile::setId);
        });
        UserProfile userProfile = userProfileRepository.findOneById(id);
        if(userProfile == null){
            return null;
        }
        mapper.map(userProfileDTO, userProfile);
        UserProfile userProfileUpdate = userProfileRepository.save(userProfile);
        UserProfileDTO returnValue = new UserProfileDTO();
        mapper.map(userProfileUpdate, returnValue);
        return returnValue;
    }
}
