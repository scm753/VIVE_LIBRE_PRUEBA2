package com.vivelibre.prueba2.sort;

import java.util.Comparator;

import com.vivelibre.prueba2.model.Book;

public class SortPubliTimestamp implements Comparator<Book>{

	@Override
	public int compare(Book b1, Book b2) {
		if (isTimestampNull(b1)) {
			return isTimestampNull(b2) ? 0 : 1;
        }
        else if (isTimestampNull(b2)) {
            return -1;
        }
		return Long.compare(
				b1.getPublicationTimestamp(), 
				b2.getPublicationTimestamp()) ;
	}
	
	private boolean isTimestampNull(Book b) {
		return b == null || b.getPublicationTimestamp() == null;
	}
}
