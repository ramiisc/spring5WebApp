package com.rpotluru.spring.spring5WebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rpotluru.spring.spring5WebApp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
