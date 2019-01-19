package com.bucom.boot.controller;

import com.bucom.boot.Enity.Spit;
import com.bucom.boot.repository.SpitRepository;
import com.bucom.boot.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitRepository spitRepository;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/spit")
    public List<Spit> findAll() {
        List<Spit> all = spitRepository.findAll();
        return all;
    }

    @PutMapping("/{id}")
    public String putUpdate(@PathVariable String id, @RequestBody Spit spit) {
        spit.setId(id);
        spitRepository.save(spit);
        return "修改成功";
    }

    @PostMapping("/spit")
    public String postSave(@RequestBody Spit spit) {
        spit.setId(idWorker.nextId() + "");
        //初始化数据完善
        spit.setPublishtime(new Date());//发布日期
        spit.setVisits(0);//浏览量
        spit.setShare(0);//分享数
        spit.setThumbup(0);//点赞数
        spit.setComment(0);//回复数
        spit.setState("1");//状态
        //如果当前添加的吐槽 有父节点(也就是上一层),那么父节点的吐槽回复数量就要+1
        if (!StringUtils.isEmpty(spit.getParentid())) {
//            Query query=new Query(Criteria.where("_id").is(spit.getParentid()));
//            Update update=new Update();
//            update.inc("comment",1);
//            mongoTemplate.updateFirst(query,update,Spit.class);
            Spit parenspit = spitRepository.findById(spit.getParentid()).get();
            parenspit.setComment(parenspit.getComment() + 1);
            spitRepository.save(parenspit);
        }
        spitRepository.save(spit);
        return "插入成功";
    }

    @PutMapping("/thumbup/{id}")
    public String thumbup(@PathVariable String id) {
        if (redisTemplate.opsForValue().get("thumbup" + id) != null) {
            return "不能重复点赞";
        }
        Spit spit = spitRepository.findById(id).get();
        spit.setThumbup(spit.getThumbup() == null ? 1 : spit.getThumbup() + 1);
        spitRepository.save(spit);
        //参数 key,value
        redisTemplate.opsForValue().set("thumbup" + id, 1);
        return "点赞成功";
    }

}
