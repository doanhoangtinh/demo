package com.dhtinh.demo.controller;

import static com.dhtinh.demo.common.UrlConstant.TRANSMISSIONMETHOD;

import java.util.List;

import javax.validation.Valid;

import com.dhtinh.demo.dto.TransmissionMethodDTO;
import com.dhtinh.demo.model.request.TransmissionMethodRequestModel;
import com.dhtinh.demo.model.response.TransmissionMethodResponseModel;
import com.dhtinh.demo.service.TransmissionMethodService;

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
@RequestMapping(TRANSMISSIONMETHOD)
public class TransmissionMethodController {
    @Autowired
    private TransmissionMethodService transmissionMethodService;
    @Autowired
    private ModelMapper mapper;

	@CrossOrigin
    @PostMapping
	public ResponseEntity<TransmissionMethodResponseModel> createTransmissionMethod(@RequestBody @Valid TransmissionMethodRequestModel transmissionMethodRequestModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		TransmissionMethodDTO transmissionMethodDTO = new TransmissionMethodDTO();
		mapper.map(transmissionMethodRequestModel, transmissionMethodDTO);
		TransmissionMethodDTO transmissionMethodCreated = transmissionMethodService.createTransmissionMethod(transmissionMethodDTO);

		if(transmissionMethodCreated == null){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		TransmissionMethodResponseModel userResponseModel = new TransmissionMethodResponseModel();
		mapper.map(transmissionMethodCreated, userResponseModel);
		return ResponseEntity.ok().body(userResponseModel);

	}

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<TransmissionMethodResponseModel>> getTransmissionMethods() {
		List<TransmissionMethodDTO> transmissionMethodDTOs  = transmissionMethodService.getTransmissionMethods();
	 	if(transmissionMethodDTOs == null){
	 		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	 	}
	 	List<TransmissionMethodResponseModel> transmissionMethodResponseModels = mapper.map(transmissionMethodDTOs, new TypeToken<List<TransmissionMethodResponseModel>>(){}.getType());
             return ResponseEntity.ok().body(transmissionMethodResponseModels);
	 }
    
}
