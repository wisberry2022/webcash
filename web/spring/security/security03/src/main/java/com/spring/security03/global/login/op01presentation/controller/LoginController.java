package com.spring.security03.global.login.op01presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.TreeMap;

@Slf4j
@RestController
public class LoginController {

    @GetMapping("/{userId}/login")
    public TreeMap<String, String> loginProcess(@PathVariable String userId) {
        log.info(userId);
        TreeMap<String, String> result = new TreeMap<>();
        result.put("id", userId);
        result.put("result", "S");
        result.put("role", "U");

        return result;
    }

}
