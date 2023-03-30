package com.example.customloginapi.domain.Login.repository;

import com.example.customloginapi.domain.Login.domain.UserEntity;
import com.example.customloginapi.domain.Login.domain.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, String> {
}
