package com.dhtinh.demo.controller;

import com.dhtinh.demo.dto.UserDTO;
import com.dhtinh.demo.model.request.LoginRequestModel;
import com.dhtinh.demo.model.response.UserResponseModel;
import com.dhtinh.demo.service.UserService;
import static com.dhtinh.demo.common.UrlConstant.LOGIN;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LOGIN)
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<UserResponseModel> login(@RequestBody LoginRequestModel loginRequestModel) {
        if (loginRequestModel.getUsername() == null || loginRequestModel.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        UserDTO userDTO = userService.getUser(loginRequestModel.getUsername(), loginRequestModel.getPassword());
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        UserResponseModel userResponseModel = new UserResponseModel();
        mapper.map(userDTO, userResponseModel);
        return ResponseEntity.ok().body(userResponseModel);
    }
}
