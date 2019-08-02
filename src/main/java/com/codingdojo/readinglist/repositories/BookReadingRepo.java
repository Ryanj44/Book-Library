package com.codingdojo.readinglist.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.readinglist.models.BookReading;

@Repository
public interface BookReadingRepo extends CrudRepository<BookReading, Long>{
	@Query("Select r FROM BookReading r WHERE reading_id = ?1")
	List<BookReading> getBookReadingWhereId(Long id);
	
	@Modifying
	@Transactional
	@Query("Delete BookReading br WHERE br.book.id =?1")
	int removeBookFromReadingList(Long id);
}
