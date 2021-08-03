package com.dhtinh.demo.service;

import java.util.List;

import com.dhtinh.demo.dto.TransmissionMethodDTO;

public interface TransmissionMethodService {
    public TransmissionMethodDTO getTransmissionMedthod(Long id);
    public List<TransmissionMethodDTO> getTransmissionMedthods();
    public TransmissionMethodDTO createTransmissionMedthod(TransmissionMethodDTO transmissionMethodDTO);
    public TransmissionMethodDTO updateTransmissionMedthod(Long id, TransmissionMethodDTO transmissionMethodDTO);
    public void deleteTransmissionMedthod(Long id);
}
