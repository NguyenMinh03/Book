package com.example.Bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title, author,isbn;
	long publicationYear ;
	double price;

	@ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

	public Book() {
    }
	public Book(String title, String author, String isbn, long publicationYear, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
		this.price = price;
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public long getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(long publicationYear) {
		this.publicationYear = publicationYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory (Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		if (this.category != null)
			return "Book [id=" + id + ", title=" + title   + " department =" + this.getCategory() + "]";		
		else
			return "Book [id=" + id + ", title=";
	}
}

	