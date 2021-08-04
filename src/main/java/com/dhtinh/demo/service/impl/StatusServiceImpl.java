package com.dhtinh.demo.service.impl;

import java.util.List;

import com.dhtinh.demo.dto.StatusDTO;
import com.dhtinh.demo.repository.StatusRepository;
import com.dhtinh.demo.service.StatusService;

import org.springframework.beans.factory.annotation.Autowired;

public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public StatusDTO createStatus(StatusDTO statusDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteStatus(Long id) {
       // statusRepository.delete();
        
    }

    @Override
    public StatusDTO getStatus(Long id) {
        // TODO Auto-generated method stub
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
