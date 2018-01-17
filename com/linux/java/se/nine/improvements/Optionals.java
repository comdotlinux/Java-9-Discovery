package com.linux.java.se.nine.improvements;

import static com.linux.java.se.nine.improvements.BookGenerator.*;

import java.util.Collections;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Optionals
 */
public class Optionals {

	public static void main(String[] args) {

		bookReader("Unmodified Output of getBooks.", getBooks());

		Optional<Book> aBook = getBooks()
							// .peek(b -> System.out.println(b.getBookAge().getYears()))
							.filter(b -> b.getBookAge().getYears() > 3)
							.findAny();

		System.out.println("In Java 8 ...");
		aBook.ifPresent(System.out::println);
		
		System.out.println("Still In Java 8 ... ");
		System.out.println(aBook.orElse(ej3e)); // returns Type
		
		System.out.println("Java 9 ... ");
		aBook.ifPresentOrElse(System.out::println, () -> System.out.println("WARNING! Not Found"));

		System.out.println("More Java 9 ... ");
		System.out.println(aBook.or(() -> Optional.of(ej3e))); // returns new Optional

		// Java 8 Style
		Optional<Book> oldBook = getBooks()
					// .peek(b -> System.out.println(b.getBookAge().getYears()))
					.filter(b -> b.getBookAge().getYears() > 3)
					.findAny();
		bookReader("Java 8 Optional usage.", oldBook.isPresent() ? Stream.of(oldBook.get()) : Stream.empty());

		bookReader("Java 9 Optional Usage", getBooks()
					// .peek(b -> System.out.println(b.getBookAge().getYears()))
					.filter(b -> b.getBookAge().getYears() > 3)
					.findAny()
					.stream());  
	}

	private static final Consumer<Integer> dottedLine = numDots -> System.out.println(String.join("", Collections.nCopies(numDots, "-")));

	private static void bookReader(String context, Stream<Book> books) {
		dottedLine.accept(100);
		System.out.println("Reading books in context :: (" + context + ")");
		books.forEachOrdered(System.out::println);
		System.out.println("Reading books in context :: (" + context + ") completed!");
		dottedLine.accept(100);
	}
}