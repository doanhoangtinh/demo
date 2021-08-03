package com.dhtinh.demo.service.impl;

import java.util.List;

import com.dhtinh.demo.dto.UserDTO;
import com.dhtinh.demo.entity.User;
import com.dhtinh.demo.repository.UserRepository;
import com.dhtinh.demo.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        mapper.map(userDTO, user);
        User userCreated = userRepository.save(user);
        if(userCreated != null){
            UserDTO returnValue = new UserDTO();
            mapper.map(userCreated, returnValue);
            return returnValue;
        }
		return null;
    }

    @Override
    public void deleteUser(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public UserDTO getUser(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserDTO> getUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
