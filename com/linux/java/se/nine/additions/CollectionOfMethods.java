package com.linux.java.se.nine.additions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * CollectionOfMethods
 */
public class CollectionOfMethods {
	public static void main(String[] args) {
		System.out.printf("%n%nPre Java 9 Vs Java 9 %s%n%n", "Lists");

		// Old
		List<Integer> oldStyleList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		print(oldStyleList, "oldStyleList");
		List<Integer> oldStyleSingleElementList = Collections.singletonList(100);
		print(oldStyleSingleElementList, "oldStyleSingleElementList");
		List<Integer> oldStyleEmptyList = Collections.emptyList();
		print(oldStyleEmptyList, "oldStyleEmptyList");

		System.out.printf("%n%n--%n%n");
		
		// Java 9
		List<Integer> newStyleList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		print(newStyleList, "newStyleList");
		List<Integer> newStyleSingleElementList = List.of(100);
		print(newStyleSingleElementList, "newStyleSingleElementList");
		List<Integer> newStyleEmptyList = List.of();
		print(newStyleEmptyList, "newStyleEmptyList");
		
		System.out.printf("%n%nPre Java 9 Vs Java 9 %s%n%n", "Sets");
		// ---------- Sets  ----------
		// Old
		Set<String> oldStyleSet = new HashSet<>();
		oldStyleSet.add("One");
		oldStyleSet.add("Two");
		oldStyleSet.add("Three");
		oldStyleSet.add("Four");
		oldStyleSet.add("Five");
		print(oldStyleSet, "oldStyleSet");
		
		Set<String> oldStyleSingleElementSet = Collections.singleton("Hundred!");
		print(oldStyleSingleElementSet, "oldStyleSingleElementSet");
		
		Set<String> oldStyleEmptySet = Collections.emptySet();
		print(oldStyleEmptySet, "oldStyleEmptySet");
		
		System.out.printf("%n%n--%n%n");
		// Java 9
		Set<String> newStyleSet = Set.of("One", "Two", "Three", "Four", "Five");
		print(newStyleSet, "newStyleSet");
		
		Set<String> newStyleSingleElementSet = Set.of("Hundred!");
		print(newStyleSingleElementSet, "newStyleSingleElementSet");
		
		Set<String> newStyleEmptySet = Set.of();
		print(newStyleEmptySet, "newStyleEmptySet");
		
		System.out.printf("%n%nPre Java 9 Vs Java 9 %s%n%n", "Maps");
		Map<Integer, String> oldStyleMap = new HashMap<>();
		oldStyleMap.put(1, "One");
		oldStyleMap.put(2, "Two");
		oldStyleMap.put(3, "Three");
		oldStyleMap.put(4, "Four");
		oldStyleMap.put(5, "Five");
		print(oldStyleMap, "oldStyleMap");
		
		Map<Integer, String> oldStyleBadMap = new HashMap<>(){{put(1, "One");put(2, "Two");put(3, "Three");put(4, "Four");put(5, "Five");}};
		print(oldStyleBadMap, "oldStyleBadMap");
		
		Map<Integer, String> oldStyleSingleElementMap = Collections.singletonMap(100, "Hundred!");
		print(oldStyleSingleElementMap, "oldStyleSingleElementMap");
		
		Map<Integer, String> oldStyleEmptyMap = Collections.emptyMap();
		print(oldStyleEmptyMap, "oldStyleEmptyMap");

		System.out.printf("%n%n--%n%n");
		
		Map<Integer, String> newStyleMap = Map.of(1, "One", 2, "Two", 3, "Three", 4, "Four", 5, "Five");
		print(newStyleMap, "newStyleMap");

		Map<Integer, String> newStyleSingleElementMap = Map.of(1, "Hundred!");
		print(newStyleSingleElementMap, "newStyleSingleElementMap");
		
		Map<Integer, String> newStyleEmptyMap = Map.of();
		print(newStyleEmptyMap, "newStyleEmptyMap");
	}
	
	private static void print(Object c, String identifier) {
		System.out.println(String.join("", Collections.nCopies(150, "-")));
		System.out.printf("%-30s :: Type : %-50s | Elements : %s%n",identifier, c.getClass(), c);
	}

}