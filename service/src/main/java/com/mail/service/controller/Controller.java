package com.mail.service.controller;

import com.mail.service.domain.DTO.UserDTO;
import com.mail.service.domain.UserModel;
import com.mail.service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private UserService service;

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserDTO userDTO ){
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDTO,userModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(userModel));
    }
}
