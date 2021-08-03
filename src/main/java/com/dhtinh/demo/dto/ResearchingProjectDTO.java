package com.dhtinh.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResearchingProjectDTO extends ProjectDTO {
    private String challenge;
    private String solution;
    private String benefit;
    
}
