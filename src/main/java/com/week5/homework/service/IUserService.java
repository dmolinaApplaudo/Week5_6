package com.week5.homework.service;

import com.week5.homework.persistence.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByEmail(String email);
}
