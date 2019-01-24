package com.bucom.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HeavenY
 * @date 2019/1/23 12:19
 */
@RestController
@RequestMapping("/test")
public class TestRequestBodyController {

    @RequestMapping("/body")
    public String test(@RequestBody User user){
    System.out.println(user.name);
        return "yes";
    }
}
