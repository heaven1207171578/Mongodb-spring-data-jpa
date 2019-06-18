package com.bucom.service.micro;

import com.bucom.service.micro.Impl.UserServiceImpl;
import com.bucom.service.micro.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name = "mongoAndJWT", fallback = UserServiceImpl.class)
public interface UserService {

  @RequestMapping(value = "/api/user")
  List<User> findUserPage();
}
