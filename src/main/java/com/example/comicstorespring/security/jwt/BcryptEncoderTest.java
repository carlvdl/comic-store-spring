package com.example.comicstorespring.security.jwt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {
    public static void main (String []args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedString = encoder.encode("pass2");
        System.out.println(encodedString);
    }
}
