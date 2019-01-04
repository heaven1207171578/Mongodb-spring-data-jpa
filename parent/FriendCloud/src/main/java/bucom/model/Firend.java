package bucom.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Firend {
    @Id //联合主键
    private String userid;
    @Id //联合主键
    private String friendid;

    private String islike;

}
