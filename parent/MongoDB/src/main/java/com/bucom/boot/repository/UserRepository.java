package com.bucom.boot.repository;

import com.bucom.boot.Enity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

  Page<User> findByUserNameLike(String userName, Pageable pageable);

  User findByUserName(String userName);
}
