package com.codingdojo.readinglist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.readinglist.models.Reading;

@Repository
public interface ReadingRepo extends CrudRepository<Reading, Long>{
	List<Reading> findAll();
}
