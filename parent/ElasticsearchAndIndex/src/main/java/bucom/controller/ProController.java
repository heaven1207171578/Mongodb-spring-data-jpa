package bucom.controller;

import bucom.model.Product;
import bucom.service.ProductService;
import entity.PageResult;
import entity.ResultData;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;

/**
 * @author HeavenY
 * @date 2019/1/29 10:07
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProController {

    @Autowired
    ProductService productService;

    @PostMapping("/pro")
    public ResultData save(@RequestBody Product product){
        Product save = productService.save(product);
        return new ResultData(true,200,"添加成功",save);
    }

    @GetMapping("/pro/{number}/{pageSize}")
    public ResultData findByKey(@RequestParam String key,@PathVariable int number,@PathVariable int pageSize){
        Pageable pageable=PageRequest.of(number-1,pageSize);
        Page<Product> byKey = productService.findByKey(key, pageable);
        return new ResultData(true,200,"查询成功",new PageResult<Product>(byKey.getTotalElements(), byKey.getContent()));
    }

}
