package com.codingdojo.readinglist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.readinglist.models.Book;
import com.codingdojo.readinglist.models.BookReading;
import com.codingdojo.readinglist.services.HomeService;

@Controller
public class HomeController {
	@Autowired
	private HomeService hS;
	
	@GetMapping("/")
	public String index(@ModelAttribute("book") Book book) {
		return "index.jsp";
	}
	
	@PostMapping("/books")
	public String createBook(@ModelAttribute("book") Book book) {
		hS.createBook(book);
		return "redirect:/";
	}
	
	@GetMapping("/books")
	public String allBooks(Model model) {
		List<Book> allBooks = hS.allBooks();
		model.addAttribute("books", allBooks);
		List<BookReading> readingList = hS.getReadingList();
		model.addAttribute("rList", readingList);
		return "library.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String viewBook(@PathVariable("id") Long id, Model model) {
		Book book = hS.findBookById(id);
		model.addAttribute("book", book);
		return "viewBook.jsp";
	}
	
	@GetMapping("/books/title")
	public String orderTitle(Model model) {
		List<Book> allBooks = hS.allBooks();
		model.addAttribute("books", allBooks);
		List<BookReading> readingList = hS.getReadingList();
		model.addAttribute("rList", readingList);
		return "library.jsp";
	}
	
	@GetMapping("/books/author")
	public String orderAuthor(Model model) {
		List<Book> allBooks = hS.bookAuthors();
		model.addAttribute("books", allBooks);
		List<BookReading> readingList = hS.getReadingList();
		model.addAttribute("rList", readingList);
		return "library.jsp";
	}
	
	@GetMapping("/books/pages")
	public String orderPages(Model model) {
		List<Book> allBooks = hS.bookPages();
		model.addAttribute("books", allBooks);
		List<BookReading> readingList = hS.getReadingList();
		model.addAttribute("rList", readingList);
		return "library.jsp";
	}
	
	@GetMapping("/books/readinglist")
	public String readingList(Model model) {
		List<BookReading> readingList = hS.getReadingList();
		model.addAttribute("rList", readingList);
		return "rList.jsp";
	}
	
	@GetMapping("/books/{id}/add")
	public String addToReadingList(@PathVariable("id") Long id) {
		hS.addBookToReadingList(id);
		return "redirect:/books/readinglist";
	}
	
	@GetMapping("/books/{id}/remove")
	public String removeFromReadingList(@PathVariable("id") Long id) {
		hS.removeBookFromReadingList(id);
		return "redirect:/books/readinglist";
	}
	@GetMapping("/books/{id}/read")
	public String markAsRead(@PathVariable("id") Long id) {
		hS.markBookAsRead(id);
		return "redirect:/books";
	}
	
	@GetMapping("/books/{id}/unread")
	public String markAsUnread(@PathVariable("id") Long id) {
		hS.markBookAsUnread(id);
		return "redirect:/books";
	}
	

}
