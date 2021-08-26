package com.dhtinh.demo.service.impl;

import java.util.List;

import com.dhtinh.demo.dto.FieldDTO;
import com.dhtinh.demo.entity.Field;
import com.dhtinh.demo.repository.FieldRepository;
import com.dhtinh.demo.service.FieldService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FieldServiceImpl implements FieldService {
    @Autowired
    private FieldRepository fieldRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public FieldDTO createField(FieldDTO fieldDTO) {
        Field field = new Field();
        mapper.map(fieldDTO, field);
        Field fieldCreated = fieldRepository.save(field);
        if(fieldCreated != null){
            FieldDTO returnValue = new FieldDTO();
            mapper.map(fieldCreated, returnValue);
            return returnValue;
        }
		return null;
    }

    @Override
    public void deleteField(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public FieldDTO getField(Long id) {
        Field field = fieldRepository.findOneById(id);
        if(field != null){
            FieldDTO returnValue = new FieldDTO();
            mapper.map(field, returnValue);
            return returnValue;
        }
        return null;
    }

    @Override
    public List<FieldDTO> getFields() {
        List<Field> fields = fieldRepository.findAll();
        if(fields.size()>0){
            List<FieldDTO> returnValue = mapper.map(fields, new TypeToken<List<FieldDTO>>(){}.getType());
            return returnValue;
        }
        return null;
    }

    @Override
    public FieldDTO updateField(Long id, FieldDTO fieldDTO) {
        // TODO Auto-generated method stub
        return null;
    }
   
}
