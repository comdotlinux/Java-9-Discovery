import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * StreamsImprovements
 */

public class StreamsImprovements {
	public static void main(String[] args) {
		List<Books> books = getBooks().skip(1).limit(3).collect(Collectors.toList());
	}



	/**
	 * New recommendation from Joshua Bloch -- If you know that the callers of your method are happy using Stream as a return, use it!!!!
	 */
	private static Streameam<Book> getBooks() {
		Book ef3e = new Book("Effective Java 3rd Edition", "Joshua Bloch", "978-0-13-468599-1", LocalDate.of(2017, Month.DECEMBER, 20));
		Book cjs9fi = new Book("Core Java SE 9 for the Impatient, 2nd Edition", "Cay S. Horstmann", "978-0-13-469472-6", LocalDate.of(2017, Month.SEPTEMBER, 15));
		Book j9fp = new Book("Java 9 for Programmers, 4th Edition", "Paul J. Deitel, Harvey Deitel", "978-0-13-477756-6", LocalDate.of(2017, Month.MAY, 11));
		Book ej2ne = new Book("Effective Java 2nd Edition", "Joshua Bloch", "ISBN-13: 978-0-321-35668-0", LocalDate.of(2008, Month.MAY, 8));
		Book rwjeep = new Book("Real World Java EE Patterns--Rethinking Best Practices", "Adam Bien", "978-1-300-14931-6", LocalDate.of(2012, Month.SEPTEMBER, 5));
		Book rwjeenh = new Book("Real World Java EE Night Hacks - Dissecting the Business Tier", "Adam Bien", "978-0-557-07832-5", LocalDate.of(2008, Month.MAY, 8));
		return Stream.of(ef3e, cjs9fi, j9fp, ej2ne, rwjeep, rwjeenh);
	}

}

class Book {
	private final String name;
	private final String author;
	private final String isbn;
	private final LocalDate publishDate;

	public Book(String name, String author, String isbn, LocalDate publishDate) {
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

}