package com.bucom.controller;

import com.bucom.service.IUserService;
import entity.ResultData;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/friend")
public class FriendController {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private IUserService userService;


    @PostMapping("friend/{firendid}/{islike}")
    public ResultData addfirend(@PathVariable String firendid, @PathVariable String islike) {
        final Claims claims = (Claims) httpServletRequest.getAttribute("roles_admin");
        if (claims != null) {
            if (claims.get("roles").equals("admin")) {
                String id = claims.getId();
                // 判断是添加好友还是添加非好友
                if (islike != null) {
                    if (islike.equals("1")) {
                        // 添加好友
                        int flag = userService.addFriend(id, firendid);
                        if (flag == 0) {
                            return new ResultData(false, StatusCode.ERROR, "buneng chongfu tianjai ");
                        }
                        if (flag == 1) {
                            return new ResultData(true, StatusCode.OK, "添加成功");
                        }
                    } else if (islike.equals("2")) {
                        // 添加非好友
                    }
                }
                return new ResultData(true, StatusCode.OK, "接收到");
            } else {
                return new ResultData(false, StatusCode.ERROR, "权限不足");
            }
        }

        return new ResultData(false, StatusCode.ERROR, "权限不足");
    }
}
