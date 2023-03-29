package com.week5.homework.service.impl;

import com.week5.homework.persistence.model.Users;
import com.week5.homework.persistence.repository.IUserRepository;
import com.week5.homework.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return userRepository.findById(email);
    }

    @Override
    public void createUser(Users users) {
        userRepository.save(users);
    }
}
