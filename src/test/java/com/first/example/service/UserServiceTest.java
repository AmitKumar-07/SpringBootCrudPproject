package com.first.example.service;

import com.first.example.entities.User;
import com.first.example.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp(){
        userService=new UserService(userRepository);
    }
    @AfterEach
    void tearDown(){
        userRepository.deleteAll();
    }

    @Test
    void canListAll() {
        //when
        userService.listAll();
        //then
        verify(userRepository).findAll();
    }

    @Test
    @Disabled
    void canGetUser() {
        //given
        int id=23;
        User user=new User(23,"Amit","bhadohi","fayta");
        given(userRepository.existsById(id)).willReturn(true);
    }

    @Test
    void canSaveUser() {
        User user=new User(83,"Amit","bhadohi","fayta");
        userService.saveUser(user);
        verify(userRepository).save(user); //method:1
//        ArgumentCaptor<User> studentArgumentCaptor = ArgumentCaptor.forClass(User.class);
//        verify(userRepository).save(studentArgumentCaptor.capture());
//        User capturedStudent = studentArgumentCaptor.getValue();
//        assertThat(capturedStudent).isEqualTo(user);//method:2
    }

    @Test
    void canUserDeleteById() {
        // given
        int id = 10;
        given(userRepository.existsById(id)).willReturn(true);
        userService.deleteUserById(id);
        verify(userRepository).deleteById(id);
    }

    @Test
    void canDeleteAllUser() {
        userService.deleteAllUser();
        verify(userRepository).deleteAll();
    }
}