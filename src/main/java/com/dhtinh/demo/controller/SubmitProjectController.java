package com.dhtinh.demo.controller;

import static com.dhtinh.demo.common.UrlConstant.PROJECT;

import com.dhtinh.demo.model.request.CommercialRequestModel;
import com.dhtinh.demo.model.response.CommercialResponseModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(PROJECT)
public class SubmitProjectController {
    @PostMapping
    public ResponseEntity<CommercialResponseModel> createCommercialProject(
            @ModelAttribute CommercialRequestModel commercialRequestModel, MultipartFile[] files) {
        //         System.out.println(file[0].getOriginalFilename());
        // System.out.println(commercialRequestModel.getScope());

        return ResponseEntity.ok().body(null);

    }
}
