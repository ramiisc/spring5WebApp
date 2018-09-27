package com.rpotluru.spring.spring5WebApp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.rpotluru.spring.spring5WebApp.model.Author;
import com.rpotluru.spring.spring5WebApp.model.Book;
import com.rpotluru.spring.spring5WebApp.model.Publisher;
import com.rpotluru.spring.spring5WebApp.repositories.AuthorRepository;
import com.rpotluru.spring.spring5WebApp.repositories.BookRepository;
import com.rpotluru.spring.spring5WebApp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	@Autowired
	private PublisherRepository publisherRepository;
	

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		init_data();
	}

	private void init_data() {
		  //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harper Collins", "USA");
        Book  ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(harper);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher Wrox = new Publisher("Wrox", "USA");
        Book noEJB = new Book("J2EE Development without EJB", "23444", Wrox);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        
        authorRepository.save(rod);
        publisherRepository.save(Wrox);
        bookRepository.save(noEJB);

	}

}
