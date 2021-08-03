package com.dhtinh.demo.service;

import java.util.List;

import com.dhtinh.demo.dto.FieldDTO;

public interface FieldService {
    public FieldDTO getField(Long id);
    public List<FieldDTO> getFields();
    public FieldDTO createField(FieldDTO fieldDTO);
    public FieldDTO updateField(Long id, FieldDTO fieldDTO);
    public void deleteField(Long id);
}
