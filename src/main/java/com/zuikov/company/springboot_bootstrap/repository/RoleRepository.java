package com.zuikov.company.springboot_bootstrap.repository;

import com.zuikov.company.springboot_bootstrap.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findRoleByName (String name);
}
