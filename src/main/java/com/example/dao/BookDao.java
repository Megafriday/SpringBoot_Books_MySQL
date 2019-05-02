package com.example.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.entity.Book;

@Repository
public class BookDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String sql = "select * from books";

	// JdbcTemplate.query() + BeanPropertyRowMapper
	public Optional<List<Book>> findAll1() {

		BeanPropertyRowMapper<Book> rowMapper
		= new BeanPropertyRowMapper<Book>(Book.class);

		List<Book> books = jdbcTemplate.query(sql, rowMapper);

		return Optional.ofNullable(books);

	}


	// JdbcTemplate.queryForList()
	public Optional<List<Map<String, Object>>> findAll2() {

		List<Map<String, Object>> books
		= jdbcTemplate.queryForList(sql);

		return Optional.ofNullable(books);
	}


	public Optional<List<Map<String, Object>>> findOne(String id) {

		sql = "select * from books where id = ?";

		List<Map<String,Object>> books
		= jdbcTemplate.queryForList(sql, id);

		return Optional.ofNullable(books);
	}


	// １行取得なら、JdbcTemplate.queryForMap() ⇒　使わない方が良い

	// １カラム取得なら、JdbcTemplate.queryForObject()


}
