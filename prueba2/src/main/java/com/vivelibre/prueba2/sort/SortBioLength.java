package com.vivelibre.prueba2.sort;


import java.util.Comparator;

import com.vivelibre.prueba2.model.Book;

public class SortBioLength implements Comparator<Book>{

	@Override
	public int compare(Book b1, Book b2) {
		if (isBioNull(b1)) {
			return isBioNull(b2) ? 0 : 1;
        }
        else if (isBioNull(b2)) {
            return -1;
        }
		return Integer.compare(
				b1.getAuthor().getBio().length(), 
				b2.getAuthor().getBio().length()) ;
	}
	
	private boolean isBioNull(Book b) {
		return b == null || b.getAuthor() == null || b.getAuthor().getBio() == null;
	}

}
