package com.bucom.boot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.bucom.boot.Enity.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	Page<User>findByUserNameLike(String userName, Pageable pageable);

	User findByUserName(String userName);
	
}
