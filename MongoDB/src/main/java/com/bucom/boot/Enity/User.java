package com.bucom.boot.Enity;

import java.io.Serializable;

import lombok.*;
import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable{
	@Id
	private Long id;
    private String userName;
    private String passWord;



    
}
