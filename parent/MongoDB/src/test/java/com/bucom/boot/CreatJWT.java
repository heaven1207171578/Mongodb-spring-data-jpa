package com.bucom.boot;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class CreatJWT {
  public static void main(String[] args) {
    JwtBuilder jwt =
        Jwts.builder()
            .setId("999")
            .setSubject("苍")
            .setIssuedAt(new Date())
            .signWith(SignatureAlgorithm.HS256, "HeavenY")
            .setExpiration(new Date(new Date().getTime() + 1130000))
            .claim("role", "admin"); // 设置过期时间
    System.out.println(jwt.compact());
  }
}
