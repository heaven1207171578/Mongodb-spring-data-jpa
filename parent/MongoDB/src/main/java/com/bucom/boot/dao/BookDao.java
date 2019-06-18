package com.bucom.boot.dao;

import com.bucom.boot.Enity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class BookDao {
  @Autowired MongoTemplate mongoTemplate;

  public void saveBook() {
    Book book = new Book(321L, "大花", new BigDecimal("123.22"));

    mongoTemplate.save(book);
  }

  public void saveBookorUser() {
    Book book = new Book(3321L, "大花", new BigDecimal("123.22"));

    mongoTemplate.save(book, "book");
  }
}
