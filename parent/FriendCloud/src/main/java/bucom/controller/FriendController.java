package bucom.controller;

import entity.ResultData;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.util.ElementScanner6;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @PostMapping("friend/{firendid}/{islike}")
    public ResultData addfirend(@PathVariable String firendid,@PathVariable int islike){
        final Claims claims = (Claims) httpServletRequest.getAttribute("roles_admin");
        if (claims!=null){
            if (claims.get("roles").equals("roles_admin")){
                return new ResultData(true,StatusCode.OK,"接收到");
            }else {
                return new ResultData(false,StatusCode.ERROR,"权限不足");
            }
        }


       return new ResultData(false,StatusCode.ERROR,"权限不足");
    }


}
