package com.bucom.boot.Enity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

//@Document(collection="book")
@Data
public class Book {
	
	public Book() {
		super();
	}
	public Book(long bookid, String bookName, BigDecimal bookprice) {
		super();
		this.bookid = bookid;
		this.bookName = bookName;
		this.bookprice = bookprice;
	}
	@Id
	private long bookid;
	@Field("book_name")
	private String bookName;
	private BigDecimal bookprice;
}
