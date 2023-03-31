package com.example.customloginapi.domain.Login.service;

import com.example.customloginapi.domain.Login.domain.UserEntity;
import com.example.customloginapi.domain.Login.domain.UserVo;
import com.example.customloginapi.domain.Login.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepo repo;

    public UserVo getUser(String id) {
        return repo.findById(id).get().getEntity();
    }

    public void createUser(UserEntity newData) {
        repo.save(newData);
    }

}
