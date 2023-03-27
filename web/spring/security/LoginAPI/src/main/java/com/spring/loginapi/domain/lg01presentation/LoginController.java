package com.spring.loginapi.domain.lg01presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;

@RestController
public class LoginController {

    @GetMapping("/login/{userId}")
    public TreeMap<String, String> getLoginStatus(@PathVariable String userId) {
        TreeMap<String, String> result = new TreeMap();

        result.put("id", userId.equals("ground444") ? userId : "none");
        result.put("status", userId.equals("ground444") ? "S" : "U");

        return result;
    }
}
