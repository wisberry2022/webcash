package com.spring.security03.global.auth;

import com.spring.security03.core.auth.getLoginStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.TreeMap;

public class getLoginStatusImpl implements getLoginStatus {

    @Override
    public boolean getStatus(String userId) {
        RestTemplate rt = new RestTemplate();
        TreeMap<String, String> result = rt.getForObject("http://localhost:8081/login/"+userId, TreeMap.class);
        System.out.println("getStatus 내부: " + result);
        if(result.get("status").equals("S")) {
            System.out.println("if문");
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean getStatus() {
        return getStatus("dlaksjd");
    }
}
