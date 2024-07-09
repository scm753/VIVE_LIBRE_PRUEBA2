package com.vivelibre.prueba2.sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.jupiter.api.Test;

import com.vivelibre.prueba2.model.Book;

public class SortPubliTimestampTest {

	private final SortPubliTimestamp sortPubliTimestamp = new SortPubliTimestamp();
	
	@Test
	public void testSortOk() {
		
		Long hoyTs = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
		Long ayerTs =LocalDate.now().minusDays(1l).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
		
		Book bookMayor = new Book();
		bookMayor.setPublicationTimestamp(hoyTs);
		
		Book bookMenor = new Book();
		bookMenor.setPublicationTimestamp(ayerTs);
		
		Book bookIgual = new Book();
		bookIgual.setPublicationTimestamp(hoyTs);
		
		int menor = sortPubliTimestamp.compare(bookMenor, bookMayor);
		assertTrue(menor < 0);
		
		int mayor = sortPubliTimestamp.compare(bookMayor, bookMenor);
		assertTrue(mayor > 0);
		
		int igual = sortPubliTimestamp.compare(bookMayor, bookIgual);
		assertEquals(igual, 0);
		
	}
}
