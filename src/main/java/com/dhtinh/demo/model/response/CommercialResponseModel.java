package com.dhtinh.demo.model.response;


import java.sql.Timestamp;

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
    private Timestamp date;
    //private List<String> file;
    private LevelDevelopmentResponseModel levelDevelopment;
    private TransmissionMethodResponseModel transmissionMethod;
    private String address;
    private String companyName;
    private String phoneNumber;
    private String email;
    private String author;
    private String website;
    private String price;
}
