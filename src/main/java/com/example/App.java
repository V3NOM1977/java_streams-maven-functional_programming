package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		List<Person> people = getPeople();

		// Imperitive Approach ❌

		// ArrayList<Person> females = new ArrayList<Person>();
		// for (Person person : people) {
		// if (person.getGender().equals(Gender.FEMALE))
		// females.add(person);
		// }
		// females.forEach(System.out::println);

		// Declarative Approach ✓

		// filter
		List<Person> females = people.stream()
				.filter(person -> person.getGender().equals(Gender.FEMALE))
				.collect(Collectors.toList());
		females.forEach(System.out::println);

		System.out.println("---------------------------------------------------------------------------------");

		// sort
		List<Person> sortedASC = people.stream()
				.sorted(Comparator.comparing(Person::getAge))
				.collect(Collectors.toList());
		sortedASC.forEach(System.out::println);

		System.out.println("--------------------------");

		List<Person> sortedDESC = people.stream()
				.sorted(Comparator.comparing(Person::getAge).reversed())
				.collect(Collectors.toList());
		sortedDESC.forEach(System.out::println);

		System.out.println("--------------------------");

		List<Person> sorted = people.stream()
				.sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
				.collect(Collectors.toList());
		sorted.forEach(System.out::println);

		System.out.println("---------------------------------------------------------------------------------");

		// allMatch
		boolean allMatch = people.stream()
				.allMatch(person -> person.getAge() > 50);
		System.out.println("Is there everybody greater than 50 :" + allMatch);

		System.out.println("---------------------------------------------------------------------------------");

		// anyMatch
		boolean anyMatch = people.stream()
				.anyMatch(person -> person.getAge() > 50);
		System.out.println("Is there anybody greater than 50 :" + anyMatch);

		System.out.println("---------------------------------------------------------------------------------");

		// noneMatch
		boolean noneMatch = people.stream()
				.anyMatch(person -> person.getName().equals("Justin Bieber"));
		System.out.println("Is there nobody named Justin Bieber :" + noneMatch);

		System.out.println("---------------------------------------------------------------------------------");

		// max
		Optional<Person> personWithMaxAge = people.stream()
				.max(Comparator.comparing(Person::getAge));
		System.out.println("Person with max age :" + personWithMaxAge.get());

		System.out.println("--------------------------");

		people.stream()
				.max(Comparator.comparing(Person::getAge))
				.ifPresent(value1 -> {
					System.out.println("Person with max age :" + value1);
				});

		System.out.println("---------------------------------------------------------------------------------");

		// min
		Optional<Person> person = people.stream()
				.min(Comparator.comparing(Person::getAge));
		System.out.println("Person with min age :" + person.get());

		System.out.println("--------------------------");

		people.stream()
				.min(Comparator.comparing(Person::getAge))
				.ifPresent(value2 -> {
					System.out.println("Person with min age :" + value2);
				});

		System.out.println("---------------------------------------------------------------------------------");

		// group
		Map<Gender, List<Person>> group = people.stream()
				.collect(Collectors.groupingBy(Person::getGender));
		group.forEach((gender, value3) -> {
			System.out.println(gender);
			group.get(gender).forEach(System.out::println);
			System.out.println();
		});

		System.out.println("---------------------------------------------------------------------------------");

		Optional<String> oldestWomen = people.stream()
				.filter(person1 -> person1.getGender().equals(Gender.FEMALE))
				.max(Comparator.comparing(Person::getAge))
				.map(Person::getName);
		System.out.println(oldestWomen);

		System.out.println("---------------------------------------------------------------------------------");

		// We can get streams of a array by using this
		String[] names = {};
		Arrays.stream(names);

		// We can use many filter as we want
		// stream().filter().filter()

		// map() is use to transform the datatype to another

	}

	private static List<Person> getPeople() {
		return List.of(
				new Person("Justin Bieber", 20, Gender.MALE),
				new Person("Alina Smith", 33, Gender.FEMALE),
				new Person("Helen White", 57, Gender.FEMALE),
				new Person("MS.Dhoni", 14, Gender.MALE),
				new Person("Raftaar", 99, Gender.MALE),
				new Person("Anna Cook", 7, Gender.FEMALE),
				new Person("Zelda Brown", 120, Gender.FEMALE));
	}

}