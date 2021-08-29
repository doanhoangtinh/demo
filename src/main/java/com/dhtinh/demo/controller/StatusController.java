package com.dhtinh.demo.controller;

import static com.dhtinh.demo.common.UrlConstant.STATUS;

import java.util.List;

import javax.validation.Valid;

import com.dhtinh.demo.dto.StatusDTO;
import com.dhtinh.demo.model.request.StatusRequestModel;
import com.dhtinh.demo.model.response.StatusResponseModel;
import com.dhtinh.demo.service.StatusService;

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
@RequestMapping(STATUS)
public class StatusController {
	@Autowired
	private StatusService statusService;
	@Autowired
	private ModelMapper mapper;

	@CrossOrigin
	@PostMapping
	public ResponseEntity<StatusResponseModel> createStatus(@RequestBody @Valid StatusRequestModel statusRequestModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		StatusDTO statusDTO = new StatusDTO();
		mapper.map(statusRequestModel, statusDTO);
		StatusDTO statusCreated = statusService.createStatus(statusDTO);

		if (statusCreated == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		StatusResponseModel userResponseModel = new StatusResponseModel();
		mapper.map(statusCreated, userResponseModel);
		return ResponseEntity.ok().body(userResponseModel);

	}

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<StatusResponseModel>> getStatuss() {
		List<StatusDTO> statusDTOs = statusService.getStatuses();
		if (statusDTOs == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		List<StatusResponseModel> statusResponseModels = mapper.map(statusDTOs,
				new TypeToken<List<StatusResponseModel>>() {
				}.getType());
		return ResponseEntity.ok().body(statusResponseModels);
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteStatus(@PathVariable Long id) {
		try {
			statusService.deleteStatus(id);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<StatusResponseModel> updateStatus(@PathVariable Long id,
			@RequestBody StatusRequestModel statusRequestModel) {
		try {
			StatusDTO statusDTO = new StatusDTO();
			mapper.map(statusRequestModel, statusDTO);
			StatusDTO statusUpdate = statusService.updateStatus(id, statusDTO);
			StatusResponseModel statusResponseModel = new StatusResponseModel();
			mapper.map(statusUpdate, statusResponseModel);
			return ResponseEntity.ok().body(statusResponseModel);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
