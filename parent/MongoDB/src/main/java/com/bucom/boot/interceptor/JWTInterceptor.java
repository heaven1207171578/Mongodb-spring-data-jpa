package com.bucom.boot.interceptor;

import com.bucom.boot.utils.JWTUtils;
import com.bucom.boot.utils.ResultData;
import com.bucom.boot.utils.StatusCode;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class JWTInterceptor implements HandlerInterceptor {
  @Autowired private JWTUtils jwtUtils;

  // 访问请求接口前经过的拦截方法
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    log.info("进入了拦截器");
    final String header = request.getHeader("Authorization");
    if (header != null && !"".equals(header)) {
      if (header.startsWith("Cang ")) {
        final String token = header.substring(5);
        try {
          final Claims claims = jwtUtils.parseJWT(token); // 解析token
          String roles = (String) claims.get("roles");
          if (roles.equals("admin") && roles != null) {
            request.setAttribute("roles_admin", token);
          } else {
            log.info("解析后的token的roles中没有andmin角色");
          }
        } catch (Exception e) {
          e.printStackTrace();
          throw new RuntimeException("token不正确");
        }
      } else {
        log.info("header的开头不正确");
      }
    } else {
      log.info("header为空");
    }
    log.info("true");
    return true;
  }
}
