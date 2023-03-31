package com.example.customloginapi.core.auth;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public interface Encoder {
    String encrypt(String origin) throws NoSuchPaddingException, NoSuchAlgorithmException;
}
