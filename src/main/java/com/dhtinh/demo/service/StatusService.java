package com.dhtinh.demo.service;

import java.util.List;

import com.dhtinh.demo.dto.StatusDTO;

public interface StatusService {
    public StatusDTO getStatus(Long id);
    public List<StatusDTO> getStatuses();
    public StatusDTO createStatus(StatusDTO statusDTO);
    public StatusDTO updateStatus(Long id, StatusDTO statusDTO);
    public void deleteStatus(Long id);
}
