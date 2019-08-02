package com.codingdojo.readinglist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.readinglist.models.Book;
import com.codingdojo.readinglist.models.BookReading;
import com.codingdojo.readinglist.models.Reading;
import com.codingdojo.readinglist.repositories.BookReadingRepo;
import com.codingdojo.readinglist.repositories.BookRepo;
import com.codingdojo.readinglist.repositories.ReadingRepo;

@Service
public class HomeService {
	@Autowired
	private BookRepo bR;
	@Autowired
	private ReadingRepo rR;
	@Autowired
	private BookReadingRepo bRR;
	
	public Book createBook(Book book) {
		return bR.save(book);
	}
	
	public List<Book> allBooks(){
		return bR.findAllByOrderByTitle();
	}
	
	public void addBookToReadingList(Long id) {
		Optional<Book> optionalBook = bR.findById(id);
		if(optionalBook.isPresent()) {
			Book book = optionalBook.get();
			Optional<Reading> optionalReading = rR.findById((long) 1);
			if(optionalReading.isPresent()) {
				Reading reading = optionalReading.get();
				BookReading br = new BookReading();
				br.setBook(book);
				br.setReading(reading);
				bRR.save(br);
			}
		}
	}
	
	public void removeBookFromReadingList(Long id) {
		bRR.removeBookFromReadingList(id);
	}
	
	public Book findBookById(Long id) {
		Optional<Book> optionalBook = bR.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public List<Book> bookTitles(){
		return bR.findAllByOrderByTitle();
	}
	
	public List<Book> bookPages(){
		return bR.findAllByOrderByPagesDesc();
	}
	public List<Book> bookAuthors(){
		return bR.findAllByOrderByAuthor();
	}
	
	public List<BookReading> getReadingList() {
		return bRR.getBookReadingWhereId((long) 1);
	}
	public void markBookAsRead(Long id) {
		Optional<Book> optionalBook = bR.findById(id);
		if(optionalBook.isPresent()) {
			Book book = optionalBook.get();
			book.setFinished(true);
			bR.save(book);
		}
	}
	
	public void markBookAsUnread(Long id) {
		Optional<Book> optionalBook = bR.findById(id);
		if(optionalBook.isPresent()) {
			Book book = optionalBook.get();
			book.setFinished(false);
			bR.save(book);
		}
	}
}
