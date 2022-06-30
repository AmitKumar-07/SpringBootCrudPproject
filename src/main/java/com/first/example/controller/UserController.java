package com.first.example.controller;

import com.first.example.entities.User;
import com.first.example.repository.UserRepository;
import com.first.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {
    @Autowired private UserService service;
    @Autowired private UserRepository repo;

    //1:getting all user
    @GetMapping("/users/all")

    public @ResponseBody List<User> showAllUser(){
        return (List<User>) repo.findAll();
    }

    //2:getting one user
    @GetMapping("/users/{id}")
    public @ResponseBody User showOneUser(@PathVariable int id){
                User user1 = service.getUser(id);
                      return user1;
    }

    //3:insert many user or single user;
    @PostMapping("/users/create")
    public @ResponseBody String insertUser(@RequestBody User user){
                  service.saveUser(user);
                  return "Saved user successfully";
    }

   //4:delete one user
    @DeleteMapping("/users/delete/{id}")
    public @ResponseBody String deleteUser(@PathVariable int id) {
                service.deleteUserById(id);
                return "User having id "+id+" is deleted Successfully";

    }

    //5:delete all user
    @DeleteMapping("/users/delete/all")
    public @ResponseBody String deleteAllUser()
    {
        long count = service.deleteAllUser();
        if(count>0) {
            return "All user deleted succesfully";
        }
        return "There is no user in database";
    }

    //6:update user infoo
    @PutMapping("/users/update/{id}")
    public @ResponseBody String updateInfo(@RequestBody User user,@PathVariable int id){
                User user1 = service.getUser(id);
               service.deleteUserById(id);//first  delete
                user1.setId(user.getId());
                user1.setStatus(user.getStatus());
                user1.setName(user.getName());
                user1.setCity(user.getCity());

                service.saveUser(user1);  //then save
                return "user updated succesfully";
    }
}
