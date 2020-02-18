package TestNoteKode.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private int age;
	private List<Integer> grades;

	private static final int MAX_NUMBER_OF_GRADES = 10;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		grades = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void addGrade(int grade) {
		if (grades.size() < MAX_NUMBER_OF_GRADES) {
			grades.add(grade);
		} else {
			throw new TooManyGradesException("For mange karakterer givet");
		}
	}

	public double averageGrade() {
		int sum = 0;
		double average = 0.0;
		for (int i = 0; i < grades.size(); i++) {
			sum += grades.get(i);
		}
		average = (double) sum / grades.size();
		return average;
	}
}
