package com.bucom.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.apache.http.protocol.RequestContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.Request;
import utils.JWTUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author HeavenY
 * @date 2019/1/19 14:57
 */
@Component
public class GatewayFilter extends ZuulFilter {
  @Autowired private JWTUtils jwtUtils;
  /**
   * 在请求前/后 执行
   *
   * @return pre:之前 post:之后
   */
  @Override
  public String filterType() {
    return "pre";
  }

  /**
   * 当前过滤器的执行顺序
   *
   * @return 数值越小 越先执行
   */
  @Override
  public int filterOrder() {
    return 0;
  }

  /**
   * 当前过滤器是否开启,
   *
   * @return true为开启
   */
  @Override
  public boolean shouldFilter() {
    return true;
  }

  /**
   * 过滤器内执行的操作,
   *
   * @return 返回任何obj的值都是表示继续执行 setsendzuulresponse(false)表示不会继续执行
   * @throws ZuulException
   */
  @Override
  public Object run() throws ZuulException {
    System.out.println("经过后台过滤器了:method-run");
    // 做一下header的转发,因为通过网关去访问接口的时候,接口的头部信息会返回null,也就是丢失
    // 先拿到request上下文 注RequestContext是zuul包下的类
    RequestContext currentContext = RequestContext.getCurrentContext();
    // 拿到request请求
    HttpServletRequest request = currentContext.getRequest();

    if (request.getMethod().equals("OPTIONS")) {
      return null;
    }
    String login = request.getRequestURI();
    // 表示请求路径里 有login这个单词 所以放行
    if (login.indexOf("login") > 0) {
      return null;
    }

    // 获取Token
    String header = request.getHeader("Authorization");
    if (StringUtils.isNotBlank(header)) {

      if (header.startsWith("Cang ")) {
        String token = header.substring(5);
        try {
          Claims claims = jwtUtils.parseJWT(token);
          String roles = (String) claims.get("roles");
          if (roles.contains("admin")) {
            // 把头信息转发到需要的服务,并且放行
            currentContext.addZuulRequestHeader("Authorization", header);
            return null;
          }

        } catch (Exception e) {
          e.printStackTrace();
          currentContext.setSendZuulResponse(false);
        }
      }
    }
    // 错误的话 表示不在继续执行
    currentContext.setSendZuulResponse(false);
    currentContext.setResponseStatusCode(403);
    currentContext.setResponseBody("权限不足");
    currentContext.getResponse().setContentType("application/json;charset=utf-8");
    return null;
  }
}
