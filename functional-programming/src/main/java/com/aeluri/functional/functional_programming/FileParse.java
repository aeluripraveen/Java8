package com.aeluri.functional.functional_programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileParse {
	public static void main(String[] args) throws IOException {

		List<String> stringList = Files
				.lines(Paths.get("C:\\Users\\apraveen\\git\\Java8\\functional-programming\\pom.xml"))
				.filter(line -> line.contains("artifactId"))
				.map(line -> line.trim().replaceAll("artifactId>", "").replaceAll("<", "").replaceAll("/", ""))
				.collect(Collectors.toList());

		System.out.println(stringList);
	}

}
