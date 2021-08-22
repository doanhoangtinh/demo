package com.dhtinh.demo.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class LevelDevelopmentRequestModel {
    @NotBlank
    private String code;
    @NotEmpty
    private String name;
}
