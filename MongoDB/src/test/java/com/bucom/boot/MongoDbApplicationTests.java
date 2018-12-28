package com.bucom.boot;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import com.bucom.boot.Enity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDbApplicationTests {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	public void testinsertMg() {
		User user = new User("123","王","qaz321","laji");
		mongoTemplate.save(user);
		System.out.println("插");
	}
	
	@Test
	public void testFindMg() {
		Query query=new Query(Criteria.where("id").is(123));
		 List<User> find = mongoTemplate.find(query, User.class);
		 for (User user : find) {
			 System.out.println(user.getUserName());
		}
		
	}
	
	@Test
	public void testupdateMg() {
		Query query=new Query(Criteria.where("id").is(123));
		Update update=new Update().set("userName", "张");
		mongoTemplate.updateFirst(query, update, User.class);
		System.out.println("更新成功");
	}
	
	
	
	
}
