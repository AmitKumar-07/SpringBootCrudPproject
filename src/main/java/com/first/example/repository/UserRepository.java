package com.first.example.repository;

import com.first.example.entities.User;
import com.sun.xml.bind.v2.runtime.reflect.Lister;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer>
{
  List<User> getUserByName(String name);
}
