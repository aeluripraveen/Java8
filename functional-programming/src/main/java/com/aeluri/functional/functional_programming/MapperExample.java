package com.aeluri.functional.functional_programming;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
/*
 * stream()
 * filter()
 * map()
 * mapToInt()
 * flatMap()
 * collect()
 * forEach()
 * sum()
 * findAny()
 * 
 * Optional
 * ifPresent()
 */

public class MapperExample {

	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(new Employee("Aeluri", 30, 10000, Arrays.asList("1", "2", "3")),
				new Employee("Swathi", 27, 50000, Arrays.asList("4", "5", "6")),
				new Employee("Saanvi", 2, 100000, Arrays.asList("7", "8", "9")));

		List<String> names = Arrays.asList("Aeluri", "Saanvi", "Swathi", "Praveen");

		emps.stream().filter(emp -> !emp.getName().equals("Aeluri")).map(emp -> emp.toString())
				.forEach(System.out::println);

		List<Employee> empList = names.stream().filter(name -> !name.equals("Aeluri")).map(name -> new Employee(name))
				.collect(Collectors.toList());

		int sum = empList.stream().mapToInt(emp -> emp.getSalary()).sum();
		System.out.println(sum);

		Optional<String> stringOptinal = emps.stream().map(emp -> emp.getPhonenos().stream())
				.flatMap(stringStream -> stringStream.filter(phoneNo -> phoneNo.equals("4"))).findAny();

		stringOptinal.ifPresent(System.out::println);

	}

	static class Employee {
		String name;
		int age;
		int salary;
		List<String> phonenos;

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		public int getSalary() {
			return salary;
		}

		public List<String> getPhonenos() {
			return phonenos;
		}

		public Employee(String name) {
			super();
			this.name = name;
			salary = 5000;

		}

		public Employee(String name, int age, int salary, List<String> phonenos) {
			super();
			this.name = name;
			this.age = age;
			this.salary = salary;
			this.phonenos = phonenos;
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
		}

	}

}
