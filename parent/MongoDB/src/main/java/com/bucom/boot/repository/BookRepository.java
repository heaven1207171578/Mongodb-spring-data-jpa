package com.bucom.boot.repository;

import com.bucom.boot.Enity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, Long> {

    //List<Book> findByBookIdAndBookName(long bookid,String bookname);
    List<Book> findByBookidAndBookName(long bookid, String bookname);


}
