package com.doitwell.genericsdemo.service;

import com.doitwell.genericsdemo.model.Admin;
import com.doitwell.genericsdemo.model.Users;

import java.util.List;

public interface  UserService {
    Admin createUser(Admin user);
    Admin getUser(Long id);
    List<Admin> getUsers();
    Admin updateUser(Long id, Admin user);
    boolean deleteUser(Long id);
}
