package com.dhtinh.demo.service;

import java.util.List;

import com.dhtinh.demo.dto.RoleOfGroupDTO;

public interface RoleOfGroupService {
    public RoleOfGroupDTO getRoleOfGroup(Long id);
    public List<RoleOfGroupDTO> getRoleOfGroups();
    public RoleOfGroupDTO createRoleOfGroup(RoleOfGroupDTO roleOfGroupDTO);
    public RoleOfGroupDTO updateRoleOfGroup(Long id, RoleOfGroupDTO roleOfGroupDTO);
    public void deleteRoleOfGroup(Long id);
}
