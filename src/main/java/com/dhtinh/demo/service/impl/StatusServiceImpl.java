package com.dhtinh.demo.service.impl;

import java.util.List;

import com.dhtinh.demo.dto.StatusDTO;
import com.dhtinh.demo.entity.Status;
import com.dhtinh.demo.repository.StatusRepository;
import com.dhtinh.demo.service.StatusService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public StatusDTO createStatus(StatusDTO statusDTO) {
        Status status = new Status();
        mapper.map(statusDTO, status);
        Status statusCreated = statusRepository.save(status);
        if(statusCreated != null){
            StatusDTO returnValue = new StatusDTO();
            mapper.map(statusCreated, returnValue);
            return returnValue;
        }
		return null;
    }

    @Override
    public void deleteStatus(Long id) {
       // statusRepository.delete();
        
    }

    @Override
    public StatusDTO getStatus(Long id) {
        Status status = statusRepository.findOneById(id);
        if(status != null){
            StatusDTO returnValue = new StatusDTO();
            mapper.map(status, returnValue);
            return returnValue;
        }
        return null;
    }

    @Override
    public List<StatusDTO> getStatuses() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public StatusDTO updateStatus(Long id, StatusDTO statusDTO) {
        // TODO Auto-generated method stub
        return null;
    }
   
}
