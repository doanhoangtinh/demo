package com.dhtinh.demo.service;

import java.util.List;

import com.dhtinh.demo.dto.TransmissionMethodDTO;

public interface TransmissionMethodService {
    public TransmissionMethodDTO getTransmissionMethod(Long id);
    public List<TransmissionMethodDTO> getTransmissionMethods();
    public TransmissionMethodDTO createTransmissionMethod(TransmissionMethodDTO transmissionMethodDTO);
    public TransmissionMethodDTO updateTransmissionMethod(Long id, TransmissionMethodDTO transmissionMethodDTO);
    public void deleteTransmissionMethod(Long id);
}
