package com.mail.service.service;

import com.mail.service.domain.UserModel;
import com.mail.service.producer.UserProducer;
import com.mail.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserProducer producer;

    @Transactional
    public UserModel save(UserModel userModel){
        userModel = repository.save(userModel);
        producer.publishMessageEmail(userModel);

        return userModel;
    }

}
