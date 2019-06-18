package com.bucom.service.micro.Impl;

import com.bucom.service.micro.UserService;
import com.bucom.service.micro.model.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author HeavenY
 * @date 2019/1/19 13:50
 */
@Component
public class UserServiceImpl implements UserService {
  @Override
  public List<User> findUserPage() {
    return Arrays.asList(new User("调用", "失败", "了", null));
  }
}
