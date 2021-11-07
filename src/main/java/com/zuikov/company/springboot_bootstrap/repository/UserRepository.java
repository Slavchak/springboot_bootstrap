package com.zuikov.company.springboot_bootstrap.repository;

import com.zuikov.company.springboot_bootstrap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail (String email);
}
