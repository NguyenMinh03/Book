package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;


@Controller
public class BookController {

@Autowired
	private BookRepository repository; 
@Autowired
private CategoryRepository drepository; 

@RequestMapping(value= {"/", "/Booklist"})
    public String studentList(Model model) {
       model.addAttribute("Books", repository.findAll());
    return "Booklist";
}
    
//add new Book
@RequestMapping(value= "/add")
public String addBook(Model model) {
	model.addAttribute("Book",new Book());
	model.addAttribute("categorys", drepository.findAll());
	return "addBook";	
}
@RequestMapping(value = "/save"	, method = RequestMethod.POST)
public String save(Book book){
repository.save(book);
return "redirect:Booklist";
}
@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
repository.deleteById(bookId);
return "redirect:../Booklist";
}
@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
public String editStudent(@PathVariable("id") Long studentId, Model model) {
	model.addAttribute("book", repository.findById(studentId));
	model.addAttribute("categorys", drepository.findAll());
	return "editBook";
}   		
}



