package bucom.dao;

import bucom.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author HeavenY
 * @date 2019/1/29 10:02
 */
public interface ProductReporistory extends ElasticsearchRepository<Product,String> {

    Page<Product>findByNameOrContentLike(String name, String content, Pageable pageable);

}
