package com.first.example.service;

import com.first.example.entities.User;
import com.first.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository repo;

    public List<User> listAll(){ //tested
        return (List<User>) repo.findAll();
    }
    public User getUser(int id)
    {
        Optional<User> byId = repo.findById(id);
        if(byId.isEmpty()) {
            throw new RuntimeException("user having id "+String.valueOf(id)+" is not present");
        }
        return byId.get();
    }

    public void saveUser(User user) throws Exception {

                if(repo.existsById(user.getId())) {
                    throw new Exception("User having id "+user.getId()+" is already present");
                }

                    repo.save(user);

    }
    public void deleteUserById(int userId) throws Exception {
        if(repo.existsById(userId)){
             repo.deleteById(userId);
        }
        else {
            throw new Exception("User having id " + String.valueOf(userId) + " is not present");
        }
    }
    public void deleteAllUser() throws Exception{

       List<User> users = (List<User>) repo.findAll();
              if(users.isEmpty())
                  throw new Exception("Database is empty");
              else
                   repo.deleteAll();
    }

    public UserService(UserRepository repo) {
        this.repo = repo;
    }
}
