package com.example.demo.Service;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

    private final String SECRET_KEY;
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days

    @Autowired
    public JwtService(String jwtSecretKey){
        this.SECRET_KEY = jwtSecretKey;
    }

    public String generateToken(String userId ) {
        return Jwts.builder()
                .setSubject(userId)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
