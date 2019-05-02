package com.example.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Book {

	private String id;
	private String title;
	private String author;
	private Date publishDate;
	private Integer price;
}
