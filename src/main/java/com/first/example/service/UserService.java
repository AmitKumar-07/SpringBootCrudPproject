package com.first.example.service;

import com.first.example.entities.User;
import com.first.example.exception.BadRequestExcepton;
import com.first.example.exception.UserNotFoundException;
import com.first.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository repo;
    //1
    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }
    //2
    public User getUser(int id) {
        boolean isTrue=repo.existsById(id);
        if(!isTrue) {
               throw new UserNotFoundException("user having id "+String.valueOf(id)+" is not present");
        }
        Optional<User> byId = repo.findById(id);
            return byId.orElseThrow(()->new NoSuchElementException("element is not here"));
    }
    //3
    public void saveUser(User user) {
             if(repo.existsById(user.getId())) {
                    throw new BadRequestExcepton("User having id "+user.getId()+" is already present");
                }
             repo.save(user);
    }
    //4
    public void deleteUserById(int userId) {
        if(!repo.existsById(userId)) {
            throw new UserNotFoundException("Student with id " + userId + " does not exists");
        }
        repo.deleteById(userId);
    }
    //5
    public long deleteAllUser() {
        long count1 = repo.count();
            repo.deleteAll();
           return count1;
    }

    public UserService(UserRepository repo) {
        this.repo = repo;
    }
}
