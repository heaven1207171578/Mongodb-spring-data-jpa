package com.bucom.boot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bucom.boot.Enity.Book;
import com.bucom.boot.Enity.User;

public interface BookRepository extends MongoRepository<Book, Long>{
	
	//List<Book> findByBookIdAndBookName(long bookid,String bookname);
	List<Book> findByBookidAndBookName(long bookid,String bookname);
	
	  
}
