package com.dhtinh.demo.model.response;

import java.util.List;

import lombok.Data;

@Data
public class CommercialResponseModel {
    private Long id;
    private String name;
    private String shortDescription;
    private UserResponseModel user;
    private FieldResponseModel field;
    private StatusResponseModel status;
    private String process;
    private String advantage;
    private String scope;
    private List<String> file;
}
