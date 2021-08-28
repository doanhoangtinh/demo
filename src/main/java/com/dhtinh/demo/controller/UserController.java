package com.dhtinh.demo.controller;

import static com.dhtinh.demo.common.UrlConstant.USER;

import javax.validation.Valid;

import com.dhtinh.demo.dto.UserDTO;
import com.dhtinh.demo.model.request.UserRequestModel;
import com.dhtinh.demo.model.response.UserResponseModel;
import com.dhtinh.demo.service.RoleService;
import com.dhtinh.demo.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private RoleService roleService;
    @Autowired
    private ModelMapper mapper;

	@CrossOrigin
    @PostMapping
	public ResponseEntity<UserResponseModel> createUser(@RequestBody @Valid UserRequestModel userRequestModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setRole(roleService.getRole(userRequestModel.getRoleId()));
		mapper.map(userRequestModel, userDTO);
		UserDTO userCreated = userService.createUser(userDTO);
		if(userCreated == null){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		UserResponseModel userResponseModel = new UserResponseModel();
		mapper.map(userCreated, userResponseModel);
		return ResponseEntity.ok().body(userResponseModel);
	}

	@CrossOrigin
    @DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.ok(true);
	}
}
