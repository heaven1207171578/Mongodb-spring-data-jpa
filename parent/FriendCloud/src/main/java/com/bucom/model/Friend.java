package com.bucom.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;


@Data
@Table(name = "friend")
@Entity
@IdClass(Friend.class)
public class Friend implements Serializable {
    @Id //联合主键
    private String userid;
    @Id //联合主键
    private String friendid;

    private String islike;

}
