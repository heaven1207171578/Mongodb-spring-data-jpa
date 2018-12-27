package com.bucom.boot.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bucom.boot.Enity.Book;
import com.bucom.boot.Enity.User;
import com.bucom.boot.dao.BookDao;
import com.bucom.boot.repository.BookRepository;
import com.bucom.boot.repository.UserRepository;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookDao bookDao;
	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping("/save")
	public void save() {
		bookDao.saveBook();
		
	}
	//不能插入到user
	@RequestMapping("/saveuser")
	public void saveuser() {
		bookDao.saveBookorUser();
		
	}
	
	@RequestMapping("/findbook")
	public List<Book>  findbook(long bookid,String bookname) {
		System.out.println(bookid);
		System.out.println(bookname);
		
		Book book=new Book();
		book.setBookid(bookid);
		book.setBookName(bookname);
		List<Book> list = bookRepository.findByBookidAndBookName(bookid,bookname);
			
		System.out.println(list);
			
			
			
		return list;
	}
	
}
