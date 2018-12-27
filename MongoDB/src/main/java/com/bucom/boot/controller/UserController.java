package com.bucom.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import com.bucom.boot.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import com.bucom.boot.Enity.User;
import com.bucom.boot.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private IdWorker idWorker;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	MongoTemplate mongoTemplate;
	
	@RequestMapping("/find")
	public Object find() {
//		Optional<User> user = userRepository.findById(123L);
//		User user = user.get();
		User user = userRepository.findById(123L).orElse(null);
		System.out.println(user.getUserName());

		return user;
	}

	@GetMapping("/user")
	public List<User> findUserAndLimit(){
		//		List<User> all = userRepository.findAll();
		/**
		 *  ^.*张$   :右匹配
		 *  ^张.*$   :左匹配
		 *	^.*张.*$ :模糊匹配
		 * Pattern.CASE_INSENSITIVE:不区分大小写
		 *
		 */
		Pattern pattern = Pattern.compile("^.*" + "Cang9" + ".*$",Pattern.CASE_INSENSITIVE);
		Query query=new Query(Criteria.where("userName").regex(pattern));
		List<User> all = mongoTemplate.find(query, User.class);
		all.forEach(user -> System.out.println(user));
		return all;
	}

	@GetMapping("/user/page")
	public Page<User> findUserPage(@RequestBody Map<String,Object>map){
		String userName = (String) map.get("userName");
		Integer pageNumber;
		pageNumber=(Integer) map.get("pageNumber");
		Integer pageSize = (Integer) map.get("pageSize");
		Sort sort=new Sort(Sort.Direction.ASC,"_id");
		Pageable pageable=PageRequest.of(pageNumber-1,pageSize,sort);
		Page<User> byUserNameLike = userRepository.findByUserNameLike(userName, pageable);
		return byUserNameLike;
	}



	@PutMapping("/user")
	public String saveUser(@RequestBody Map<String,Object>map){
		String name =  (String)map.get("name");
		String pwd = (String) map.get("pwd");
		for (int i=201;i<=300;i++){
			User user=new User(idWorker.nextId(),name+i,pwd);
			userRepository.save(user);
     		System.out.println("插入第"+i+"条");
		}

		return "插入成功";
	}


}
