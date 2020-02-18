package ex2ex3;

public class Exercise2 {

    public static void main(String[] args) {

        System.out.println("Ex2: (2.1, 2.2, 2.3)");
        College c = new College("La Masia");
        Student s1 = new Student(0, "Messi");
        Student s2 = new Student(1, "Xavi");
        Student s3 = new Student(2, "Iniesta");

        c.addStudent(s1);
        c.addStudent(s2);
        c.addStudent(s3);

        s1.addGrade(12);
        s1.addGrade(10);
        s2.addGrade(12);
        s2.addGrade(7);
        s3.addGrade(10);
        s3.addGrade(4);

        System.out.println("Student with id 0: " + c.findStudent(0));
        System.out.println("Grades of student with id 0: " + c.findStudent(0).getGrades());
        System.out.println("Average grade: " + c.calcAverage());

        System.out.println("\nEx3: (3.1, 3.2, 3.3)");
        Student s4 = new Student(0, "Messi");

        System.out.println("s1 compareTo s2: " + s1.compareTo(s2));
        System.out.println("s1 compareTo s4: " + s1.compareTo(s4));

        System.out.println("s1 compare s2: " + s1.compare(s1, s2));
        System.out.println("s1 compare s4: " + s1.compare(s1, s4));

        System.out.println("s1 equals s2: " + s1.equals(s2));
        System.out.println("s1 equals s4: " + s1.equals(s4));

        System.out.println("s1 hashcode: " + s1.hashCode());
        System.out.println("s2 hashcode: " + s2.hashCode());
        System.out.println("s4 hashcode: " + s4.hashCode());

    }

}
