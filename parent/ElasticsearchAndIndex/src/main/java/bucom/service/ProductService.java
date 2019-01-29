package bucom.service;

import bucom.dao.ProductReporistory;
import bucom.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import utils.IdWorker;

/**
 * @author HeavenY
 * @date 2019/1/29 10:03
 */
@Service
public class ProductService {

    @Autowired
    private ProductReporistory productReporistory;

    @Autowired
    private IdWorker idWorker;


    public Product save(Product product){
        Product save = productReporistory.save(product);
        return save;
    }

    public Page<Product>findByKey(String key, Pageable pageable){

        return productReporistory.findByNameOrContentLike(key,key,pageable);
    }
}
