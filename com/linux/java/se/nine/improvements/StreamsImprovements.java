package com.linux.java.se.nine.improvements;

import static java.util.stream.Collectors.toList;
import static com.linux.java.se.nine.improvements.BookGenerator.getBooks;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import com.linux.java.se.nine.improvements.BookGenerator.Book;


/**
 * StreamsImprovements
 */

public class StreamsImprovements {

	public static void main(String[] args) {
		Predicate<Book> publishDateGreaterThan2012 = b -> b.getPublishDate().getYear() > 2012;

		print(getBooks().collect(toList()), "***** Original List *****");

		List<Book> booksWithSkip = getBooks()
				.skip(3)
				.collect(toList());
		print(booksWithSkip, "Java 8 ... skip 3");

		List<Book> booksWithDropWhile = getBooks()
				.dropWhile(publishDateGreaterThan2012)
				.collect(toList());
		print(booksWithDropWhile, "Java 9 ... dropWhile publishDateGreaterThan2012");

		List<Book> booksWithLimit = getBooks()
				.limit(3)
				.collect(toList());
		print(booksWithLimit, "Java 8 ... limit");

		List<Book> booksWithTakeWhile = getBooks()
				.takeWhile(publishDateGreaterThan2012)
				.collect(toList());
		print(booksWithTakeWhile, "Java 9 ... takeWhile publishDateGreaterThan2012");

	}

	private static void print(List<?> list, String identifier) {
		System.out.println(identifier);
		list.forEach(System.out::println);
		System.out.println(String.join("", Collections.nCopies(150, "-")));
	}

}
