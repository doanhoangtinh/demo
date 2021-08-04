package com.dhtinh.demo.service;

import java.util.List;

import com.dhtinh.demo.dto.UserDTO;

public interface UserService {
    public UserDTO getUser(Long id);
    public UserDTO getUser(String username, String password);
    public List<UserDTO> getUsers();
    public UserDTO createUser(UserDTO userDTO);
    public UserDTO updateUser(Long id, UserDTO userDTO);
    public void deleteUser(Long id);

}
