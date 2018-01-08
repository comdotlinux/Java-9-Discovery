package com.linux.java.se.nine.streams.improvment;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;


/**
 * StreamsImprovements
 */

public class StreamsImprovements {
	private static final Book ej3e = new Book("Effective Java 3rd Edition", "Joshua Bloch", "978-0-13-468599-1", LocalDate.of(2017, Month.DECEMBER, 20));
	private static final Book cjs9fi = new Book("Core Java SE 9 for the Impatient, 2nd Edition", "Cay S. Horstmann", "978-0-13-469472-6", LocalDate.of(2017, Month.SEPTEMBER, 15));
	private static final Book j9fp = new Book("Java 9 for Programmers, 4th Edition", "Paul J. Deitel, Harvey Deitel", "978-0-13-477756-6", LocalDate.of(2017, Month.MAY, 11));
	private static final Book ej2e = new Book("Effective Java 2nd Edition", "Joshua Bloch", "978-0-321-35668-0", LocalDate.of(2008, Month.MAY, 8));
	private static final Book rwjeep = new Book("Real World Java EE Patterns", "Adam Bien", "978-1-300-14931-6", LocalDate.of(2012, Month.SEPTEMBER, 5));
	private static final Book rwjeenh = new Book("Real World Java EE Night Hacks", "Adam Bien", "978-0-557-07832-5", LocalDate.of(2008, Month.MAY, 8));


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


	/**
	 * New recommendation from Joshua Bloch -- If you know that the callers of your method are happy using Stream as a return, use it!!!!
	 */
	private static Stream<Book> getBooks() {
		return Stream.of(ej3e, cjs9fi, j9fp, ej2e, rwjeep, rwjeenh).sorted(comparing(Book::getPublishDate).reversed());
	}

	private static void print(List<?> list, String identifier) {
		System.out.println(identifier);
		list.forEach(System.out::println);
		System.out.println(String.join("", Collections.nCopies(150, "-")));
	}


	static class Book {
		private final String name;
		private final String author;
		private final String isbn;
		private final LocalDate publishDate;

		Book(String name, String author, String isbn, LocalDate publishDate) {
			this.name = name;
			this.author = author;
			this.isbn = isbn;
			this.publishDate = publishDate;
		}

		public Period getBookAgeinMonths() {
			return Period.between(publishDate, LocalDate.now());
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the isbn
		 */
		public String getIsbn() {
			return isbn;
		}

		/**
		 * @return the publishDate
		 */
		public LocalDate getPublishDate() {
			return publishDate;
		}

		/**
		 * @return the author
		 */
		public String getAuthor() {
			return author;
		}

		@Override
		public String toString() {
			return String.format("Book{name=%-50s\tauthor=%-30s\tisbn=%-20s\tpublishDate=%10s}", name, author, isbn, publishDate);
		}

	}
}
