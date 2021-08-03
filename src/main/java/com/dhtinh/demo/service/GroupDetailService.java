package com.dhtinh.demo.service;

import java.util.List;

import com.dhtinh.demo.dto.GroupDetailDTO;

public interface GroupDetailService {
    public GroupDetailDTO getGroupDetail(Long id);
    public List<GroupDetailDTO> getGroupDetails();
    public GroupDetailDTO createGroupDetail(GroupDetailDTO groupDetailDTO);
    public GroupDetailDTO updateGroupDetail(Long id, GroupDetailDTO groupDetailDTO);
    public void deleteGroupDetail(Long id);
}
