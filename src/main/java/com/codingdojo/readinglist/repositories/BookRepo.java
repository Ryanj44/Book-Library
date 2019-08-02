package com.codingdojo.readinglist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.readinglist.models.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long>{
	List<Book> findAllByOrderByTitle();
	List<Book> findAllByOrderByAuthor();
	List<Book> findAllByOrderByPagesDesc();
}
