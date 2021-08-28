package com.dhtinh.demo.service.impl;

import java.util.List;
import com.dhtinh.demo.dto.UserDTO;
import com.dhtinh.demo.entity.User;
import com.dhtinh.demo.repository.UserRepository;
import com.dhtinh.demo.service.UserService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
        User user = userRepository.findOneById(id);
        userRepository.delete(user);
    }

    @Override
    public UserDTO getUser(Long id) {
        userRepository.findById(id);
        return null;
    }

    @Override
    public UserDTO getUser(String username, String password) {
        User user = userRepository.findOneByUsernameAndPassword(username,password);
        if(user != null){
            UserDTO returnValue = new UserDTO();
            mapper.map(user, returnValue);
            return returnValue;
        }
        return null;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        if(users.size()>0){
            List<UserDTO> returnValue = mapper.map(users, new TypeToken<List<UserDTO>>(){}.getType());
            return returnValue;
        }
        return null;
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
