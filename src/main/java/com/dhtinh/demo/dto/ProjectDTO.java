package com.dhtinh.demo.dto;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectDTO {
    private Long id;
//    private String code;
    private String name;
    private String shortDescription;
    private String address;
    private String companyName;
    private String phoneNumber;
    private String email;
    private String author;
    private String website;
    //private Date date;
    private UserProfileDTO user;
    private UserProfileDTO inspector;
    private FieldDTO field;
    private StatusDTO status;
    // private List<FileInfomationDTO> fileInfomations;

}
