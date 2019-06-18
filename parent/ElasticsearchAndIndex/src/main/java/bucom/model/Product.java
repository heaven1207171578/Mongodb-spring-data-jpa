package bucom.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @author HeavenY
 * @date 2019/1/28 18:26
 */
@Document(indexName = "test", type = "product")
@Data
public class Product {

  @Id private String id;

  // 是否索引:表示看该字段是否能被搜索
  // 是否分词:表示搜索的时候是整体匹配,还是单词匹配
  // 是否存储:表示是否在页面上显示
  @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
  private String name; // 标题

  @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
  private String content; // 内容

  private String state; // 状态
}
