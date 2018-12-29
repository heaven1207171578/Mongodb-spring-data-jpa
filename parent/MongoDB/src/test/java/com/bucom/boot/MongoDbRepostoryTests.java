package com.bucom.boot;

import com.bucom.boot.Enity.User;
import com.bucom.boot.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDbRepostoryTests {

	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testinsertMg() {
		User user = new User("123","王","qaz321","垃圾taba");
		Optional<User> findById = userRepository.findById("123");
		
	}
	
	
	
	
}
