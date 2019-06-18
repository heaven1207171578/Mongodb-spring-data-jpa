package com.bucom.controller;

import com.bucom.service.micro.UserService;
import com.bucom.service.micro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/fegintest")
public class UserController {

  @Autowired private UserService userService;

  @Autowired private HttpServletRequest request;

  @RequestMapping("/micro-user")
  public List<User> findUser() {
    System.out.println(request.getHeader("Authorization"));
    return userService.findUserPage();
  }

  @RequestMapping("/api")
  public User users() {

    return new User("123", "456", "123", null);
  }

  public static void main(String[] args) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String strDate = "2019-01-04 14:25:33";
    // Date parse = sdf.parse(strDate);
    ParsePosition pp = new ParsePosition(1); // 用来标明解析开始位，其实也可以不明传pos的
    Date dd = sdf.parse(strDate, pp);
    System.out.println(dd);
  }
}
