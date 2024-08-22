package com.example.SpringSecEx.model;

import com.example.SpringSecEx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    @PostConstruct
    public void printUsers() {
        List<Users> users = userRepository.findAll();
        for (Users user : users) {
            System.out.println("User ID: " + user.getId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
            System.out.println("----------------------------");
        }
    }
}
