package com.doitwell.genericsdemo.controller;

import com.doitwell.genericsdemo.model.Admin;
import com.doitwell.genericsdemo.model.Users;
import com.doitwell.genericsdemo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping
    public List<Admin> getAll(){
        return userService.getUsers();
    }
    @GetMapping("{id}")
    public Admin getOne(@PathVariable Long id){
        return userService.getUser(id);
    }
    @PostMapping
    public Admin createOne(@RequestBody Admin user){
        return userService.createUser(user);
    }
    @PutMapping("{id}")
    public Admin updateUser(@PathVariable Long id, @RequestBody Admin user){
        return userService.updateUser(id,user);
    }
    @DeleteMapping("{id}")
    public boolean deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
