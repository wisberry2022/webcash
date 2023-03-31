package com.example.customloginapi.global.auth;

import com.example.customloginapi.core.auth.Encoder;

import javax.crypto.NoSuchPaddingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PasswordEncoder implements Encoder {

    public PasswordEncoder() {}

    public String encrypt(String origin) throws NoSuchPaddingException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(origin.getBytes());

        return new String(md.digest());
    }
}
