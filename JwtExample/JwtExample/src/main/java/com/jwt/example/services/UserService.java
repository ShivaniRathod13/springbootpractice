package com.jwt.example.services;


import com.jwt.example.entities.User;
import com.jwt.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
 //private List<User> store =new ArrayList<>();

//    public UserService() {
//        store.add(new User(UUID.randomUUID().toString(),"Divya","divya@gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(),"Deepika","Deepika@gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(),"Sonali","Sonali@gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(),"Nikita","Nikita@gmail.com"));

//
//
//    }

     @Autowired
    private UserRepository userRepository;

     @Autowired
     private PasswordEncoder passwordEncoder;
    public List<User>getUsers(){

        return userRepository.findAll();
    }

    public User createUser(User user){
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);

    }
}
