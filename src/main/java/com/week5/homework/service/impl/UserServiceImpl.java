package com.week5.homework.service.impl;

import com.week5.homework.exception.UserAlreadyExistsException;
import com.week5.homework.exception.UserNotFoundException;
import com.week5.homework.persistence.model.Users;
import com.week5.homework.persistence.repository.IUserRepository;
import com.week5.homework.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users findByEmail(String email) {
        Optional<Users> user = userRepository.findById(email);
        if (user.isEmpty()){
           throw new UserNotFoundException("User with email: "+email+" Doesn't Exists");
        }
        return user.get();
    }

    @Override
    public void createUser(Users users) {
        if(!userRepository.existsById(users.getEmail())){
            userRepository.save(users);
        }else {
            String msg = "The user with the email account: "+ users.getEmail()+ " already exists";
            throw new UserAlreadyExistsException(msg);
        }
    }

    @Override
    public List<Users> findAll() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(),false)
                .toList();
    }

    @Override
    public void updateUser(Users users) {
        if(userRepository.existsById(users.getEmail())){
            userRepository.save(users);
        }else {
            throw new UserNotFoundException("User with email: "+users.getEmail()+" Doesn't Exists");
        }
    }


}
