package com.vivelibre.prueba2.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class BookDate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2658100061177939864L;
	private Book book;
	private String date;
	
	private BookDate(Book book) {
		this.book = book;
	}
	
	public static Optional<BookDate> createBookDate(Optional<Book> optBook) {
		if (optBook.isEmpty())
			return Optional.empty();
		
		BookDate bookDate = new BookDate(optBook.get());
		bookDate.setDate(createTimeStamp());
		return Optional.of(bookDate);
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	public String getDate() {
		return date;
	}

	private void setDate(String date) {
		this.date = date;
	}
	
	private static String createTimeStamp() {
		LocalDate ld = LocalDate.now();
		return ld.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
	}

	@Override
	public String toString() {
		return "BookDate [book=" + book + ", date=" + date + "]";
	}
	
}
