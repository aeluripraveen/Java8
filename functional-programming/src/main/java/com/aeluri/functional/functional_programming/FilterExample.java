package com.aeluri.functional.functional_programming;

import java.util.Arrays;
import java.util.List;

public class FilterExample {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Aeluri", "Saanvi", "Swathi", "Praveen");

//      names.stream().filter(name->isNotAeluri(name)).forEach(name-> System.out.println(name));
		names.stream().filter(FilterExample::isNotAeluri).forEach(System.out::println);
	}

	private static boolean isNotAeluri(String name) {
		return !name.equals("Aeluri");
	}
}
