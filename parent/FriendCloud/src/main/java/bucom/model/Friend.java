package bucom.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.io.Serializable;


@Data
@Entity
public class Friend implements Serializable {
    @Id //联合主键
    private String userid;
    @Id //联合主键
    private String friendid;

    private String islike;

}
