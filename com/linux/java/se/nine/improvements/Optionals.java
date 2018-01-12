package com.linux.java.se.nine.improvements;

import static java.util.stream.Collectors.toList;
import static com.linux.java.se.nine.improvements.BookGenerator.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.linux.java.se.nine.improvements.BookGenerator.Book;

/**
 * Optionals
 */
public class Optionals {

	public static void main(String[] args) {

		bookReader(getBooks());

		Optional<Book> aBook = getBooks()
							.peek(b -> System.out.println(b.getBookAge().getMonths()))
							.filter(b -> b.getBookAge().getMonths() > 3)
							.findAny();

		System.out.println("In Java 8 ... ");
		aBook.ifPresent(System.out::println);
		
		System.out.println("Still In Java 8 ... ");
		System.out.println(aBook.orElse(ej3e));
		
		System.out.println("Java 9 ... ");
		aBook.ifPresentOrElse(System.out::println, () -> System.out.println("WARNING! Not Found"));

		System.out.println("More Java 9 ... ");
		System.out.println(aBook.or(() -> Optional.of(ej3e)));

		bookReader(getBooks());

		// Won't compile
		// bookReader(getBooks()
		// 			.peek(b -> System.out.println(b.getBookAge().getMonths()))
		// 			.filter(b -> b.getBookAge().getMonths() > 12)
		// 			.findAny());  

		bookReader(getBooks()
					.peek(b -> System.out.println(b.getBookAge().getMonths()))
					.filter(b -> b.getBookAge().getMonths() > 12)
					.findAny()
					.stream());  


		
	}

	private static void bookReader(Stream<Book> books) {
		System.out.println("Reading books");
		books.forEachOrdered(System.out::println);
		System.out.println("Reading completed!");
	}
}