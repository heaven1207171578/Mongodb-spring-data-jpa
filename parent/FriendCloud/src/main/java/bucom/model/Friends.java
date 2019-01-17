package bucom.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author HeavenY
 * @date 2019/1/17 18:12
 */
@Data
@Entity
public class Friends {
    @Id //联合主键
    private String userid;
    @Id //联合主键
    private String friendid;

    private String islike;
}
