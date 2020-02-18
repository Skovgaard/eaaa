package ex2ex3;

import java.util.LinkedHashMap;
import java.util.Map;

public class College {

    private String name;

    private Map<Integer, Student> students;

    public College(String name) {
        this.name = name;
        students = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        students.put(student.getStudentNo(), student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    // Pre: count > 0
    public double calcAverage() {
        int sum = 0;
        int count = 0;

        for (Student s : students.values()) {
            for (Integer grade : s.getGrades()) {
                sum += grade;
                count++;
            }
        }
        return sum / count;
    }

    public Student findStudent(int studentNo) {
        for (Student s : students.values()) {
            if (s.getStudentNo() == studentNo)
                return s;
        }
        return null;
    }

    @Override
    public String toString() {
        return "ex2ex3.College{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
