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
    //getting all user
    @GetMapping("/users/all")
    @ResponseBody
    public List<User> showAllUser(){
//        List<User> listUsers=service.listAll();
//        return listUsers;
        return (List<User>) repo.findAll();
    }

    //getting one user
    @GetMapping("/users/{id}")
    @ResponseBody
    public User showOneUser(@PathVariable int id){
        User user2=new User();
            try {
                User user1 = service.getUser(id);
                    return user1;
                }
              catch (Exception e)
             {
                e.getMessage();
             }
            user2.setStatus("user is not present");
            return user2;
    }

    //insert many user or single user;
    @PostMapping("/users/create")
    @ResponseBody
    public String insertUser(@RequestBody User user){

              try{
                  service.saveUser(user);
                  return "Saved user successfully";
              }catch (Exception e){
                  return e.getMessage();
              }
    }

   //delete one user
    @DeleteMapping("/users/delete/{id}")
    public @ResponseBody String deleteUser(@PathVariable int id) {
            try{
                service.deleteUserById(id);
                return "User having id "+id+" is deleted Successfully";
            }catch (Exception e){
                return e.getMessage();
            }
    }

    //delete all user
    @DeleteMapping("/users/delete/all")
    @ResponseBody
    public String deleteAllUser()
    {

        try {
            service.deleteAllUser();
            return "All user deleted succesfully";
        }catch (Exception e){
            return e.getMessage();
    }
    }

    //update user infoo
    @PutMapping("/users/update")
    @ResponseBody
    public String updateInfo(@RequestBody User user){
            try {
                User user1 = service.getUser(user.getId());
                user1.setStatus(user.getStatus());
                user1.setName(user.getName());
                user1.setCity(user.getCity());
                return "user updated succesfully";
            } catch (Exception e) {
                return e.getMessage();
            }
    }

    public UserController(UserService service) {
        this.service=service;
    }
}
