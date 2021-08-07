package com.dhtinh.demo.model.request;


import lombok.Data;

@Data
public class CommercialRequestModel {
    private String name;
    private String shortDescription;
    private Long userId;
    private Long fieldId;
    private Long statusId;
    private String process;
    private String advantage;
    private String scope;
}
