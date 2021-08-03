package com.dhtinh.demo.controller;

import static com.dhtinh.demo.common.UrlConstant.USER;

import com.dhtinh.demo.dto.UserDTO;
import com.dhtinh.demo.model.request.UserRequestModel;
import com.dhtinh.demo.model.response.UserResponseModel;
import com.dhtinh.demo.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(USER)
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping
	public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel) {
		if (userRequestModel.getEmail() == null || userRequestModel.getPassword() == null
				|| userRequestModel.getFullName() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		UserDTO userDTO = new UserDTO();
		mapper.map(userRequestModel, userDTO);
		UserDTO userCreated = userService.createUser(userDTO);
		UserResponseModel userResponseModel = new UserResponseModel();
		mapper.map(userCreated, userResponseModel);
		return ResponseEntity.ok().body(userResponseModel);

	}
}
