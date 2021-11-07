package com.zuikov.company.springboot_bootstrap.service;

import com.zuikov.company.springboot_bootstrap.model.User;
import com.zuikov.company.springboot_bootstrap.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(User user) {
         userRepository.save(user);
    }

    @Override
    public User findByEmail (String email) {
        return userRepository.findByEmail(email);
    }
}
