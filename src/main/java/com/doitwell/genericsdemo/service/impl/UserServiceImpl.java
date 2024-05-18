package com.doitwell.genericsdemo.service.impl;

import com.doitwell.genericsdemo.model.Admin;
import com.doitwell.genericsdemo.model.Users;
import com.doitwell.genericsdemo.repository.UserRepository;
import com.doitwell.genericsdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public Admin createUser(Admin user) {
        return userRepository.save(user);
    }

    @Override
    public Admin getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Admin> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Admin updateUser(Long id, Admin user) {
        Optional<Admin> check = userRepository.findById(id);
        if (check.isPresent()){
            check.get().setFirstname(user.getFirstname());
            check.get().setLastname(user.getLastname());
            check.get().setEmail(user.getEmail());
            check.get().setConnected(true);
            check.get().setPassword(user.getPassword());
        }
        return check.get();
    }

    @Override
    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
