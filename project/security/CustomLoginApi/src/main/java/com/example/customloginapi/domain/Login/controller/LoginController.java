package com.example.customloginapi.domain.Login.controller;

import com.example.customloginapi.domain.Login.domain.UserEntity;
import com.example.customloginapi.domain.Login.service.UserServiceImpl;
import com.example.customloginapi.global.auth.PasswordEncoder;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@RestController
@AllArgsConstructor
public class LoginController {

    private final UserServiceImpl service;
    private final PasswordEncoder encoder;

    @PostMapping("/api/v1/sign")
    public ResponseEntity<?> validateLogin(@RequestParam String id, String password) {
        try {
            System.out.println(id + " " + encoder.encrypt(password));
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok("{\"status\":\"ok\"}");
    }

    @PostMapping("/api/v1/sign/{userId}")
    public ResponseEntity<?> createUser(@PathVariable String userId, @RequestParam String password, String email) {
        System.out.println(service);

        try {
            service.createUser(UserEntity.builder()
                            .id(userId).password(encoder.encrypt(password))
                            .assignDate(new Date()).email(email)
                    .build());
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("{\"status\":\"ok\"}");


    }
}
