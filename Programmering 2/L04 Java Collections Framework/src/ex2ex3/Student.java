package ex2ex3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student>, Comparator<Student> {

    private int studentNo;
    private String name;
    private List<Integer> grades;

    private College college;

    public Student(int studentNo, String name) {
        this.studentNo = studentNo;
        this.name = name;
        grades = new ArrayList<>();
    }

    public int getStudentNo() {
        return studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public List<Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "ex2ex3.Student{" +
                "studentNo=" + studentNo +
                ", name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }

    @Override
    public int compareTo(Student s) {
        return Integer.compare(studentNo, s.studentNo);
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj.getClass() == this.getClass()) {
//            ex2ex3.Student s = (ex2ex3.Student) obj;
//            return studentNo == s.getStudentNo();
//        } else
//            return false;
//    }

//    @Override
//    public int hashCode() {
//        return Integer.toString(studentNo).hashCode();
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentNo == student.studentNo;
    }

    @Override
    public int hashCode() {
//        return Objects.hash(studentNo);
        return 31 * Integer.toString(studentNo).hashCode() << 16;
    }
}
