import java.util.ArrayList;
import java.util.List;

class Student {
    String name;
    int rollNumber;
    String address;
    String phoneNumber;

    public Student(String name, int rollNumber, String address, String phoneNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

class StudentRecord {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.rollNumber == rollNumber);
    }

    public Student findStudentByRollNumber(int rollNumber) {
        return students.stream()
                .filter(student -> student.rollNumber == rollNumber)
                .findFirst()
                .orElse(null);
    }

    public Student findStudentByName(String name) {
        return students.stream()
                .filter(student -> student.name.equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}

public class StudentRecordApp {
    public static void main(String[] args) {
        StudentRecord studentRecord = new StudentRecord();

        Student student1 = new Student("John Doe", 101, "123 Main St", "555-1234");
        Student student2 = new Student("Jane Smith", 102, "456 Oak St", "555-5678");

        studentRecord.addStudent(student1);
        studentRecord.addStudent(student2);

        System.out.println("All Students:");
        for (Student student : studentRecord.getAllStudents()) {
            System.out.println(student);
        }

        int rollNumberToFind = 101;
        Student foundStudent = studentRecord.findStudentByRollNumber(rollNumberToFind);
        if (foundStudent != null) {
            System.out.println("Student found by roll number " + rollNumberToFind + ": " + foundStudent);
        } else {
            System.out.println("Student with roll number " + rollNumberToFind + " not found.");
        }
    }
}
