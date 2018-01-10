package com.neilist.mrs.service;

import com.neilist.mrs.domain.User;
import com.neilist.mrs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    RestTemplate restTemplate;

    public User save(User user) {
        userRepository.save(user);
        return user;
    }

//    private Optional<User> saveToUserService(User user) {
//        restTemplate.post
//    }

}
