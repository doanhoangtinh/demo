package com.dhtinh.demo.controller;

import static com.dhtinh.demo.common.UrlConstant.ROLE;

import java.util.List;

import javax.validation.Valid;

import com.dhtinh.demo.dto.RoleDTO;
import com.dhtinh.demo.model.request.RoleRequestModel;
import com.dhtinh.demo.model.response.RoleResponseModel;
import com.dhtinh.demo.service.RoleService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@CrossOrigin
	@PostMapping
	public ResponseEntity<RoleResponseModel> createRole(@RequestBody @Valid RoleRequestModel roleRequestModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		RoleDTO roleDTO = new RoleDTO();
		mapper.map(roleRequestModel, roleDTO);
		RoleDTO roleCreated = roleService.createRole(roleDTO);

		if (roleCreated == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		RoleResponseModel userResponseModel = new RoleResponseModel();
		mapper.map(roleCreated, userResponseModel);
		return ResponseEntity.ok().body(userResponseModel);

	}

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<RoleResponseModel>> getRoles() {
		List<RoleDTO> roleDTOs = roleService.getRoles();
		if (roleDTOs == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		List<RoleResponseModel> roleResponseModels = mapper.map(roleDTOs, new TypeToken<List<RoleResponseModel>>() {
		}.getType());
		return ResponseEntity.ok().body(roleResponseModels);
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteRole(@PathVariable Long id) {
		try {
			roleService.deleteRole(id);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<RoleResponseModel> updateRole(@PathVariable Long id,	@RequestBody RoleRequestModel roleRequestModel) {
		try {
			RoleDTO roleDTO = new RoleDTO();
			mapper.map(roleRequestModel, roleDTO);
			RoleDTO roleUpdated = roleService.updateRole(id, roleDTO);
			RoleResponseModel userResponseModel = new RoleResponseModel();
			mapper.map(roleUpdated, userResponseModel);
			return ResponseEntity.ok().body(userResponseModel);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
