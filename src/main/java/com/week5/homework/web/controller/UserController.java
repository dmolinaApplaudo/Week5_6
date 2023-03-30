package com.week5.homework.web.controller;

import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import com.week5.homework.exception.UserNotFoundException;
import com.week5.homework.persistence.model.Users;
import com.week5.homework.service.IUserService;
import com.week5.homework.web.controller.requestbody.EmailRequestBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody Users users){
        userService.createUser(users);
    }

    @GetMapping(value = "/")
    @ResponseBody
    public Users findUserByEmail(@RequestBody EmailRequestBody email){
        return userService.findByEmail(email.getEmail());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Users> findAll(){
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Map<String, String> handleValidationExceptions(HttpMessageNotReadableException ex) {
        PropertyBindingException exception = (PropertyBindingException) ex.getCause();
        Map<String, String> errors = new HashMap<>();
        String[] errorMessage = exception.getMessage().split(" ");
        errors.put(exception.getPropertyName(), errorMessage[0]+" "+errorMessage[1]+" "+errorMessage[2]);
        return errors;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({UserNotFoundException.class})
    public Map<String, String> handleExistingUserError(UserNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("email", ex.getMessage());
        return errors;
    }

}
