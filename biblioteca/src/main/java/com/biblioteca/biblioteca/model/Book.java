package com.biblioteca.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	private String id;
	private String title;
	private String author;
	private Boolean isRead = false;
	private LocalDateTime ldt;
}
