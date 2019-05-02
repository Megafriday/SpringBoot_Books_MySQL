package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Book;
import com.example.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;

	// JdbcTemplate.query() + BeanPropertyRowMapper
	@GetMapping("/books1")
	public String getBooks1(Model model) {

		List<Book> books = bookService.findAll1().orElse(null);
		model.addAttribute("books", books);

		return "books1";
	}

	// JdbcTemplate.queryForList()
	@GetMapping("/books2")
	public String getBooks2(Model model) {

		List<Map<String, Object>> books
		= bookService.findAll2().orElse(null);

		model.addAttribute("books", books);

		return "books2";
	}

	@GetMapping("/search")
	public String getSearch(Model model) {
		model.addAttribute("book", new Book());
		return "search";
	}

	@PostMapping("/search")
	public String postSearch(@RequestParam String id,
			Model model) {

		List<Map<String,Object>> books
		= bookService.findOne(id).orElse(null);

		model.addAttribute("id", id);
		model.addAttribute("books", books);

		return "search";
	}














}
