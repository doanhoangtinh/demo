package com.dhtinh.demo.model.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CommercialRequestModel {
    private String process;
    private String advantage;
    private String scope;
}
