package com.vivelibre.prueba2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vivelibre.prueba2.model.Book;
import com.vivelibre.prueba2.model.BookDate;

public class PruebaFilterTest {

	
	@Test
	public void testOk() throws StreamReadException, DatabindException, IOException {
		PruebaFilter pruebaFilter = new PruebaFilter();
		
		String filter = "the";
		String jsonFileBooks = "src/test/resources/books.json";
		ObjectMapper objectMapper = new ObjectMapper();
		Book[] arrBooks = objectMapper.readValue(new File(jsonFileBooks), Book[].class);
		
		Optional<BookDate> result = pruebaFilter.callFilter(filter, Arrays.asList(arrBooks));
		
		assertTrue(result.isPresent());
		
	}
}
