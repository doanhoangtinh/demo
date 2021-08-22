package com.dhtinh.demo.controller;

import static com.dhtinh.demo.common.UrlConstant.FIELD;

import java.util.List;

import javax.validation.Valid;

import com.dhtinh.demo.dto.FieldDTO;
import com.dhtinh.demo.model.request.FieldRequestModel;
import com.dhtinh.demo.model.response.FieldResponseModel;
import com.dhtinh.demo.service.FieldService;

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
@RequestMapping(FIELD)
public class FieldController {
    @Autowired
    private FieldService fieldService;
    @Autowired
    private ModelMapper mapper;

	@CrossOrigin
    @PostMapping
	public ResponseEntity<FieldResponseModel> createField(@RequestBody @Valid FieldRequestModel fieldRequestModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		FieldDTO fieldDTO = new FieldDTO();
		mapper.map(fieldRequestModel, fieldDTO);
		FieldDTO fieldCreated = fieldService.createField(fieldDTO);

		if(fieldCreated == null){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		FieldResponseModel userResponseModel = new FieldResponseModel();
		mapper.map(fieldCreated, userResponseModel);
		return ResponseEntity.ok().body(userResponseModel);

	}

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<FieldResponseModel>> getFields() {
		List<FieldDTO> fieldDTOs  = fieldService.getFields();
	 	if(fieldDTOs == null){
	 		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	 	}
	 	List<FieldResponseModel> fieldResponseModels = mapper.map(fieldDTOs, new TypeToken<List<FieldResponseModel>>(){}.getType());
             return ResponseEntity.ok().body(fieldResponseModels);
	 }
    
}
