package com.dhtinh.demo.controller;

import static com.dhtinh.demo.common.UrlConstant.ROLE;

import com.dhtinh.demo.dto.RoleDTO;
import com.dhtinh.demo.model.request.RoleRequestModel;
import com.dhtinh.demo.model.response.RoleResponseModel;
import com.dhtinh.demo.service.RoleService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ROLE)
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping
	public ResponseEntity<RoleResponseModel> createRole(@RequestBody RoleRequestModel roleRequestModel) {
		// if (userRequestModel.getEmail() == null || userRequestModel.getPassword() == null
		// 		|| userRequestModel.getFullName() == null) {
		// 	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		// }
		RoleDTO userDTO = new RoleDTO();
		mapper.map(roleRequestModel, userDTO);
		RoleDTO userCreated = roleService.createRole(userDTO);
		RoleResponseModel userResponseModel = new RoleResponseModel();
		mapper.map(userCreated, userResponseModel);
		return ResponseEntity.ok().body(userResponseModel);

	}
    
}
