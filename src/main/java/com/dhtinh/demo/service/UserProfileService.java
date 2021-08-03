package com.dhtinh.demo.service;

import java.util.List;

import com.dhtinh.demo.dto.UserProfileDTO;

public interface UserProfileService {
    public UserProfileDTO getUserProfile(Long id);
    public List<UserProfileDTO> getUserProfiles();
    public UserProfileDTO createUserProfile(UserProfileDTO userProfileDTO);
    public UserProfileDTO updateUserProfile(Long id, UserProfileDTO userProfileDTO);
    public void deleteUserProfile(Long id);
}
