package com.zuikov.company.springboot_bootstrap.service;



import com.zuikov.company.springboot_bootstrap.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    User getById(Long id);

    void saveUser(User user);

    void deleteById(Long id);

    void update(User user);

    User findByEmail (String email);

}
