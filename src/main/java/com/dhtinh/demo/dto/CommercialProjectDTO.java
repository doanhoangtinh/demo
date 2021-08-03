package com.dhtinh.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommercialProjectDTO extends ProjectDTO {
    private String process;
    private String advantage;
    private String scope;
    private LevelDevelopmentDTO levelDevelopmentDTO;
    private TransmissionMethodDTO transmissionMethodDTO;
}
