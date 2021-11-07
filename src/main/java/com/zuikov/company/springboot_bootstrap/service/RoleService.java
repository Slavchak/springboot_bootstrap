package com.zuikov.company.springboot_bootstrap.service;

import com.zuikov.company.springboot_bootstrap.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> allRoles();

    Role findRoleByName(String name);
}

