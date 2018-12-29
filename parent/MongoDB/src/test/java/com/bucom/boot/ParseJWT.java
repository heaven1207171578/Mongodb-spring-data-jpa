package com.bucom.boot;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * 解析JWT成对象
 *
 */
public class ParseJWT {
  public static void main(String[] args) {
      Claims heavenY = Jwts.parser()
              .setSigningKey("HeavenY")//自定义的盐
              .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI5OTkiLCJzdWIiOiLoi40iLCJpYXQiOjE1NDU5ODg3MzAsImV4cCI6MTU0NTk4OTg2MCwicm9sZSI6ImFkbWluIn0.OsOBBM_ohu5EZjZquolgT9lnq3Ua62Q4wjCueDqMh7Y")
              .getBody();
    System.out.println("用户名:"+heavenY.getSubject());
    System.out.println("时间:"+heavenY.getIssuedAt());
    System.out.println("id:"+heavenY.getId());
    System.out.println("过期时间:"+heavenY.getExpiration());
    System.out.println("自定义key:"+heavenY.get("role"));
  }
}
