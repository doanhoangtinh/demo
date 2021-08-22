package com.dhtinh.demo.service.impl;

import java.util.List;

import com.dhtinh.demo.dto.TransmissionMethodDTO;
import com.dhtinh.demo.entity.TransmissionMethod;
import com.dhtinh.demo.repository.TransmissionMethodRepository;
import com.dhtinh.demo.service.TransmissionMethodService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransmissionMethodServiceImpl implements TransmissionMethodService {
    @Autowired 
    private TransmissionMethodRepository transmissionMethodRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public TransmissionMethodDTO createTransmissionMethod(TransmissionMethodDTO transmissionMethodDTO) {
        TransmissionMethod transmissionMethod = new TransmissionMethod();
        mapper.map(transmissionMethodDTO, transmissionMethod);
        TransmissionMethod transmissionMethodCreated = transmissionMethodRepository.save(transmissionMethod);
        if(transmissionMethodCreated != null){
            TransmissionMethodDTO returnValue = new TransmissionMethodDTO();
            mapper.map(transmissionMethodCreated, returnValue);
            return returnValue;
        }
        
		return null;
    }

    @Override
    public void deleteTransmissionMethod(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public TransmissionMethodDTO getTransmissionMethod(Long id) {
        TransmissionMethod transmissionMethod = transmissionMethodRepository.findOneById(id);
        if(transmissionMethod != null){
            TransmissionMethodDTO returnValue = new TransmissionMethodDTO();
            mapper.map(transmissionMethod, returnValue);
            return returnValue;
        }
        return null;
    }

    @Override
    public List<TransmissionMethodDTO> getTransmissionMethods() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TransmissionMethodDTO updateTransmissionMethod(Long id, TransmissionMethodDTO transmissionMethodDTO) {
        // TODO Auto-generated method stub
        return null;
    }
   
}
