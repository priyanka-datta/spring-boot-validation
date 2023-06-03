package com.priyanka.datta.controller;

import com.priyanka.datta.entity.User;
import com.priyanka.datta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Validated
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public ResponseEntity<Object> saveUser(@RequestBody @Valid @NotNull User user){
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ResponseEntity<Object> findAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}/details")
    public ResponseEntity<Object> findAllUsers(@PathVariable(value = "userId") Integer userId){
        return new ResponseEntity<>(userRepository.findById(userId), HttpStatus.OK);
    }
}
