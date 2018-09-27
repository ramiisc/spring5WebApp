package com.rpotluru.spring.spring5WebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rpotluru.spring.spring5WebApp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
