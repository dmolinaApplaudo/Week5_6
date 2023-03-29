package com.week5.homework.service.impl;

import com.week5.homework.persistence.model.User;
import com.week5.homework.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private IUserService userService;

    public UserServiceImpl(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }
}
