package com.vivelibre.prueba2;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vivelibre.prueba2.model.Book;
import com.vivelibre.prueba2.model.BookDate;
import com.vivelibre.prueba2.sort.SortBioLength;
import com.vivelibre.prueba2.sort.SortPubliTimestamp;


public class PruebaFilter {
	
	public Optional<BookDate> callFilter(String filter, List<Book> books) {
		return filter(filter, books);
	}
	
	private Optional<BookDate> filter(String filter, List<Book> books) {
		// Escriba por pantalla los libros que no tengan fecha de publicación
		books.stream()
			.filter(b -> b.getPublicationTimestamp() == null)
			.forEach(System.out::println);
		
		/* Devuelva los libros que contengan la cadena de caracteres en el nombre, en el
			resumen y en la biografia del autor del libro. En caso de encontrar más de un
			libro en la lista devolver aquel más recientemente publicado. Además se deberá
			devolver el libro con un campo date adicional que contenga el timestamp con el
			siguiente formato de fecha: mm-dd-yyyy 
		 */
		Optional<Book> optBook = 
				books.stream()
			.filter(b -> 
				b.getTitle().contains(filter)
				&& b.getSummary().contains(filter)
				&& b.getAuthor().getBio().contains(filter)
			)
			.sorted(new SortPubliTimestamp().reversed())
			.collect(Collectors.reducing((a, b) -> a));

		/* Ordenar la lista primero agrupada por fecha de publicación y luego ordenada 
		 	por la biografia de autor más corta.
		 */
		books.stream()
			.sorted(new SortBioLength())
			.collect(
					Collectors.groupingBy(
							b->b.getPublicationTimestamp()==null?"N/A":b.getPublicationTimestamp(),
							LinkedHashMap::new, Collectors.toList()))
			.forEach((k, v) -> System.out.println((k + ":" + v)));
		
		return BookDate.createBookDate(optBook);
	}
}
