package com.bucom.service.micro;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("mongoAndJWT")
public interface UserService {}
