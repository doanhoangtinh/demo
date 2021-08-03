package com.dhtinh.demo.service;

import java.util.List;

import com.dhtinh.demo.dto.FileInfomationDTO;

public interface FileInfomationService {
    public FileInfomationDTO getFileInfomation(Long id);
    public List<FileInfomationDTO> getFileInfomations();
    public FileInfomationDTO createFileInfomation(FileInfomationDTO fileInfomationDTO);
    public FileInfomationDTO updateFileInfomation(Long id, FileInfomationDTO fileInfomationDTO);
    public void deleteFileInfomation(Long id);
}
