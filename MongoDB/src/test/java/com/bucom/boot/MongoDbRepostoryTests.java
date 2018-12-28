package com.bucom.boot;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import com.bucom.boot.Enity.User;
import com.bucom.boot.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDbRepostoryTests {

	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testinsertMg() {
		User user = new User("123","王","qaz321","垃圾taba");
		Optional<User> findById = userRepository.findById(123L);
		
	}
	
	
	
	
}
