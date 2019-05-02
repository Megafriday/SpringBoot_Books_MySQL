package com.example.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.BookDao;
import com.example.entity.Book;

@Service
@Transactional
public class BookService {

	@Autowired
	BookDao bookDao;

	// JdbcTemplate.query() + BeanPropertyRowMapper
	public Optional<List<Book>> findAll1() {
		return bookDao.findAll1();
	}

	// JdbcTemplate.queryForList()
	public Optional<List<Map<String, Object>>> findAll2() {
		return bookDao.findAll2();
	}

	public Optional<List<Map<String, Object>>> findOne(String id) {
		return bookDao.findOne(id);
	}
}
