package com.dhtinh.demo.controller;

import static com.dhtinh.demo.common.UrlConstant.LEVELDEVELOPMENT;

import java.util.List;

import javax.validation.Valid;

import com.dhtinh.demo.dto.LevelDevelopmentDTO;
import com.dhtinh.demo.model.request.LevelDevelopmentRequestModel;
import com.dhtinh.demo.model.response.LevelDevelopmentResponseModel;
import com.dhtinh.demo.service.LevelDevelopmentService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LEVELDEVELOPMENT)
public class LevelDevelopmentController {
    @Autowired
    private LevelDevelopmentService levelDevelopmentService;
    @Autowired
    private ModelMapper mapper;

	@CrossOrigin
    @PostMapping
	public ResponseEntity<LevelDevelopmentResponseModel> createLevelDevelopment(@RequestBody @Valid LevelDevelopmentRequestModel levelDevelopmentRequestModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		LevelDevelopmentDTO levelDevelopmentDTO = new LevelDevelopmentDTO();
		mapper.map(levelDevelopmentRequestModel, levelDevelopmentDTO);
		LevelDevelopmentDTO levelDevelopmentCreated = levelDevelopmentService.createLevelDevelopment(levelDevelopmentDTO);

		if(levelDevelopmentCreated == null){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		LevelDevelopmentResponseModel userResponseModel = new LevelDevelopmentResponseModel();
		mapper.map(levelDevelopmentCreated, userResponseModel);
		return ResponseEntity.ok().body(userResponseModel);

	}

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<LevelDevelopmentResponseModel>> getLevelDevelopments() {
		List<LevelDevelopmentDTO> levelDevelopmentDTOs  = levelDevelopmentService.getLevelDevelopments();
	 	if(levelDevelopmentDTOs == null){
	 		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	 	}
	 	List<LevelDevelopmentResponseModel> levelDevelopmentResponseModels = mapper.map(levelDevelopmentDTOs, new TypeToken<List<LevelDevelopmentResponseModel>>(){}.getType());
             return ResponseEntity.ok().body(levelDevelopmentResponseModels);
	 }
    
}
