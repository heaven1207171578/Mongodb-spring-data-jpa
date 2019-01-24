package com.bucom.boot.controller;

import com.bucom.boot.Enity.User;
import com.bucom.boot.repository.UserRepository;
import com.bucom.boot.utils.IdWorker;
import com.bucom.boot.utils.JWTUtils;
import com.bucom.boot.utils.ResultData;
import com.bucom.boot.utils.StatusCode;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
@CrossOrigin
@RefreshScope //自动刷新github配置中心的配置文件(在配置文件自定义的配置)
public class UserAndJWTController {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private HttpServletRequest request;//获取请求头部

    @GetMapping(value = "/login", produces = "application/json")
    public ResultData login(@RequestParam Map<String, Object> map) {
        String name = (String) map.get("name");
        String pwd = (String) map.get("pwd");
        User byName = userRepository.findByUserName(name);
        /**
         * 第一个参数为前端传来的值
         * 第二个参数数据库查的密码加密值
         */
        boolean matches = encoder.matches(pwd, byName.getPassWord());
        if (matches) {
            String token = jwtUtils.createJWT(byName.getId(), byName.getUserName(), (String) byName.getRoles());
            Map<String, Object> result = new HashMap<>();
            result.put("token", token);
            result.put("roles", byName.getRoles());
            return new ResultData(true, StatusCode.OK, "登陆成功,创建token", result);
        }
        return new ResultData(false, StatusCode.ACCESSERROR, "登陆失败");
    }


    // 这段经常用的检查请求头的Token的代码 放到拦截器中 进行统一处理
//	@DeleteMapping("/delete/{id}")
//	public ResultData deleteAndRoles(@PathVariable String id){
//		final String header = request.getHeader("Authorization");
//		if (header==null&&"".equals(header)){
//			return new ResultData(false,StatusCode.ACCESSERROR,"删除失败,权限不存在");
//		}
//		//boolean.startsWith(?)判断当前字符串是否是以另外一个给定的字符串“开头”的
//		if (!header.startsWith("Cang ")){
//			return new ResultData(false,StatusCode.ACCESSERROR,"删除失败,token格式不足");
//		}
//		final String token = header.substring(5);//拿到从请求头中第5位的token
//		try {
//			final Claims claims = jwtUtils.parseJWT(token);//解析token
//			String roles = (String) claims.get("roles");
//			if (roles.equals("admin")&&roles!=null){
//				userRepository.deleteById(id);
//			}
//		}catch (Exception e){
//			return new ResultData(false,StatusCode.ACCESSERROR,"删除失败,token时间过期");
//		}
//		return new ResultData(true,StatusCode.OK,"删除成功");
//	}
    @DeleteMapping("/delete/{id}")
    public ResultData deleteAndRoles(@PathVariable String id) {
        String admin = (String) request.getAttribute("roles_admin");
        if (StringUtils.isNotEmpty(admin)) {
            userRepository.deleteById(id);
            return new ResultData(true, StatusCode.OK, "删除成功");
        }
        return new ResultData(false, StatusCode.ERROR, "删除失败");
    }


    @GetMapping("/user")
    public ResultData findUserAndLimit() {
        //List<User> all = userRepository.findAll();
        /**
         *  ^.*张$   :右匹配
         *  ^张.*$   :左匹配
         *	^.*张.*$ :模糊匹配
         * Pattern.CASE_INSENSITIVE:不区分大小写
         *
         */
        Pattern pattern = Pattern.compile("^.*" + "" + ".*$", Pattern.CASE_INSENSITIVE);
        Query query = new Query(Criteria.where("userName").regex(pattern));
        List<User> all = mongoTemplate.find(query, User.class);
        all.forEach(user -> System.out.println(user + "8081"));
        return new ResultData(true, StatusCode.OK, "成功",all);
    }

    @GetMapping("/user/page")
    public Page<User> findUserPage(@RequestBody Map<String, Object> map) {
        String userName = (String) map.get("userName");
        Integer pageNumber;
        pageNumber = (Integer) map.get("pageNumber");
        Integer pageSize = (Integer) map.get("pageSize");
        Sort sort = new Sort(Sort.Direction.ASC, "_id");
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        Page<User> byUserNameLike = userRepository.findByUserNameLike(userName, pageable);
        return byUserNameLike;
    }

    @RequestMapping("/find")
    public Object find() {
//		Optional<User> user = userRepository.findById(123L);
//		User user = user.get();
        User user = userRepository.findById("123").orElse(null);
        System.out.println(user.getUserName());

        return user;
    }


//	@PostMapping("/user")
//	public String saveUser(@RequestBody Map<String,Object>map){
//		String name =  (String)map.get("name");
//		String pwd = (String) map.get("pwd");
//		for (int i=201;i<=300;i++){
//			User user=new User(idWorker.nextId(),name+i,pwd);
//			userRepository.save(user);
//     		System.out.println("插入第"+i+"条");
//		}
//
//		return "插入成功";
//	}

    @PostMapping("/user")
    public String saveUser(@RequestBody Map<String, Object> map) {
        String name = (String) map.get("name");
        String pwd = (String) map.get("pwd");
        String roles = (String) map.get("roles");
        String encodePwd = encoder.encode(pwd);
        User user = new User(idWorker.nextId() + "", name, encodePwd, roles);
        userRepository.save(user);
        return "注册成功";
    }

    @RequestMapping("/jsonpuser")
    public String jsonpUser(@RequestParam("callback") String callback) {
        Pattern pattern = Pattern.compile("^.*" + "" + ".*$", Pattern.CASE_INSENSITIVE);
        Query query = new Query(Criteria.where("userName").regex(pattern));
        List<User> all = mongoTemplate.find(query, User.class);
        all.forEach(user -> System.out.println(user + "8081"));
        System.out.println("callback:"+callback);
        return callback+"("+all+")";
    }

}
