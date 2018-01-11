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
		IntStream.iterate(0, i -> i + 1).limit(100).forEachOrdered(i -> System.out.printf("%d ", i));
		
		System.out.printf("%n%nStill Java 8 Code .... %n");
		Stream.iterate(0, i -> i < 100, i -> i + 1).forEachOrdered(i -> System.out.printf("%d ", i));
		
		System.out.printf("%n%nFinally java 9 Improvement! .... %n");
		IntStream.iterate(0, i -> i < 100, i -> i + 1).forEachOrdered(i -> System.out.printf("%d ", i));

		System.out.printf("%n%nFor the benefit of out terminal :)%n");
	}
	
}