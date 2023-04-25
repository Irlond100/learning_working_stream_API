package threads_recalls_basic_methods.population_ensus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
		List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
		Collection<Person> persons = new ArrayList<>();
		for (int i = 0; i < 10_000_000; i++) {
			persons.add(new Person(
				names.get(new Random().nextInt(names.size())),
				families.get(new Random().nextInt(families.size())),
				new Random().nextInt(100),
				Sex.values()[new Random().nextInt(Sex.values().length)],
				Education.values()[new Random().nextInt(Education.values().length)])
			);
		}
		numberOfMinors(persons);
		listFamiliesConscripts(persons);
		listFamiliesEfficient(persons);
	}
	
	private static List<String> listFamiliesEfficient(Collection<Person> persons) {
		return persons.stream()
			.filter(p -> p.getEducation().equals(Education.HIGHER))
			.filter(p -> (p.getSex() == Sex.WOMAN && p.getAge() > 18 && p.getAge() <= 60)
				|| (p.getSex() == Sex.MAN && p.getAge() > 18 && p.getAge() <= 65))
			.sorted(Comparator.comparing(Person::getFamily))
			.map(Person::getFamily)
			.collect(Collectors.toList());
	}
	
	private static List<String> listFamiliesConscripts(Collection<Person> persons) {
		return persons.stream()
			.filter(f -> f.getAge() > 18 && f.getAge() <= 27 && f.getSex().equals(Sex.MAN))
			.map(Person::getFamily)
			.collect(Collectors.toList());
	}
	
	private static long numberOfMinors(Collection<Person> persons) {
		return persons.stream()
			.filter(p -> p.getAge() > 18)
			.count();
	}
	
}
