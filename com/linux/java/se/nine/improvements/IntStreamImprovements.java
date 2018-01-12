package com.linux.java.se.nine.improvements;

import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * IntStreamImprovements
 */
public class IntStreamImprovements {

	// private static final Consumer<Integer> prettyPrint = i -> System.out.printf("%d ", i);

	public static void main(String[] args) {
		System.out.printf("Java 8 Code .... %n");
		IntStream.iterate(0, i -> i + 1)
				.limit(100)
				.forEachOrdered(i -> System.out.printf("%d ", i));
		
		System.out.printf("%n%nStill Java 8 Code .... %n");
		Stream.iterate(0, i -> i + 1)
			.limit(100)
			// .skip(5)
			.forEachOrdered(i -> System.out.printf("%d ", i));
		
		System.out.printf("%n%nFinally In java 9 .... %n");
		IntStream.iterate(0, i -> i < 100, i -> i + 1)
				.forEachOrdered(i -> System.out.printf("%d ", i));

		System.out.printf("%n%nAlso in java 8 + some features from Java 9 .... %n");
		IntStream.iterate(0, i -> i + 1)
				.limit(100)
				// .skip(10)
				.takeWhile(i -> i < 95)
				// .dropWhile(i -> i > 15)
				.forEachOrdered(i -> System.out.printf("%d ", i));


		System.out.printf("%n%nFor the benefit of our terminal :)%n");
	}
	
}