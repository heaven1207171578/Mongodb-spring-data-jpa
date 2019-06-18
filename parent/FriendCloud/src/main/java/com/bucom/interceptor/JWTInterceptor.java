package com.bucom.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import utils.JWTUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JWTInterceptor implements HandlerInterceptor {
  @Autowired private JWTUtils jwtUtils;

  // 访问请求接口前经过的拦截方法
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    System.out.println("经过了拦截器");
    final String header = request.getHeader("Authorization");
    if (header != null && !"".equals(header)) {
      if (header.startsWith("Cang ")) {
        final String token = header.substring(5);
        try {
          final Claims claims = jwtUtils.parseJWT(token); // 解析token
          String roles = (String) claims.get("roles");
          if (roles.equals("admin") && roles != null) {
            request.setAttribute("roles_admin", claims); // 直接放到域中 解析好的token
          }
        } catch (Exception e) {
          throw new RuntimeException("token不正确");
        }
      }
    }
    System.out.println("true");
    return true;
  }
}
