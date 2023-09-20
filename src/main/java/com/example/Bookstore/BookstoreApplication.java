package com.example.Bookstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
@SpringBootApplication
public class BookstoreApplication {

 	
	public static void main(String[] args)throws Exception {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository drepository) {
	return (args) -> {
		drepository.save(new Category("Novel"));
		drepository.save(new Category("Allegory"));
		drepository.save(new Category("Detective and Mystery"));
		drepository.save(new Category("Historical Fiction"));
		drepository.save(new Category("Horror"));
		drepository.save(new Category("Romance"));
		
	Book b1 = new Book("A Fare well to arms", "Ernest Hemingway", "1232323-21", 1929, 232, drepository.findByName("Novel").get(0));
	Book b2 = new Book("Animal Farm","George Orwell", "2212343-5", 1945, 232, drepository.findByName("Allegory").get(0));
	
	repository.save(b1);
	repository.save(b2);
	
	
	
	
	};
	}

}
