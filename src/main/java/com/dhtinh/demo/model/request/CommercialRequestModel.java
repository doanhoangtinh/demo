package com.dhtinh.demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommercialRequestModel {
    private String name;
    private String shortDescription;
    private Long user;
    private Long field;
    private Long status;
    private Long levelDevelopment;
    private Long transmissionMethod;
    private String process;
    private String advantage;
    private String scope;
    private String address;
    private String companyName;
    private String phoneNumber;
    private String email;
    private String author;
    private String website;
    private String price;

}
