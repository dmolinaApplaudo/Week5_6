package com.week5.homework.service;

import com.week5.homework.persistence.model.Users;

import java.util.List;

public interface IUserService {
    Users findByEmail(String email);

    void createUser(Users users);

    List<Users> findAll();
}
