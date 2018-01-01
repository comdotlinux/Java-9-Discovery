package com.linux.java.se.nine.streams.improvment;

class Book {
	private final String name;
	private final String author;
	private final String isbn;
	private final LocalDate publishDate;

	public Book(String name, String author, String isbn, LocalDate publishDate) {
		this.name = name;
		this.author = author;
		this.isbn = isbn;
		this.publishDate = publishDate;
	}

	public Period getBookAgeinMonths() {
		return Period.between(publishDate, LocalDate.now());
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @return the publishDate
	 */
	public LocalDate getPublishDate() {
		return publishDate;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

}