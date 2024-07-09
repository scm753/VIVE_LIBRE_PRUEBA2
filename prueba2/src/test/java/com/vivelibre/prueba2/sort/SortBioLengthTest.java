package com.vivelibre.prueba2.sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.vivelibre.prueba2.model.Author;
import com.vivelibre.prueba2.model.Book;

public class SortBioLengthTest {

	private final SortBioLength sortBioLength = new SortBioLength();
	
	@Test
	public void testSortOk() {
		
		Book bookMayor = new Book();
		Author authorMayor = new Author();
		authorMayor.setBio("12345");
		bookMayor.setAuthor(authorMayor);
		
		Book bookMenor = new Book();
		Author authorMenor = new Author();
		authorMenor.setBio("12");
		bookMenor.setAuthor(authorMenor);
		
		Book bookIgual = new Book();
		Author authorIgual = new Author();
		authorIgual.setBio("12345");
		bookIgual.setAuthor(authorIgual);
		
		int menor = sortBioLength.compare(bookMenor, bookMayor);
		assertTrue(menor < 0);
		
		int mayor = sortBioLength.compare(bookMayor, bookMenor);
		assertTrue(mayor > 0);
		
		int igual = sortBioLength.compare(bookMayor, bookIgual);
		assertEquals(igual, 0);
		
	}
}
