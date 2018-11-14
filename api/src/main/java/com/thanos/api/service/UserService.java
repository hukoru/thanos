package com.thanos.api.service;

import com.thanos.api.domain.User;
import com.thanos.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public User createBy() {
        User user = new User();
        return userRepository.save(user);
    }


}
