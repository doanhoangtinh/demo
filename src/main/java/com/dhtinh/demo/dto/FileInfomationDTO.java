package com.dhtinh.demo.dto;

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
public class FileInfomationDTO {
    private Long id;
    private String code;
    private String url;
    private ProjectDTO projectDTO;
}
