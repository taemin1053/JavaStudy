package objectoverring;

import java.util.Objects;

public class Student {
    String name;
    String number;
    int birthYear;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return birthYear == student.birthYear && Objects.equals(name, student.name) && Objects.equals(number, student.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, birthYear);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    public  Student(String name, String number, int birthYear) {
        this.name = name;
        this.number = number;
        this.birthYear = birthYear;
    }
}
