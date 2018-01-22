package com.neilist.mrs.controller;

import com.neilist.mrs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public abstract class BaseController {

    @Autowired
    private UserRepository userRepository;

    protected com.neilist.mrs.domain.User getUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(user.getUsername());
    }
}
