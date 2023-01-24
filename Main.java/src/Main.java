import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private String id;

    public Student(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                return;
            }
        }
    }

    public Student getStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                return students.get(i);
            }
        }
        return null;
    }

    public void printStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getName() + " " + students.get(i).getAge() + " " + students.get(i).getId());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Get student details");
            System.out.println("4. Print all students");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = scanner.next();

                System.out.print("Enter age: ");
                int age = scanner.nextInt();

                System.out.print("Enter id: ");
                String id = scanner.next();

                Student student = new Student(name, age, id);
                system.addStudent(student);

                System.out.println("Student added successfully!");
            } else if (choice == 2) {
                System.out.print("Enter student ID: ");
                String id = scanner.next();

                if (system.getStudent(id) == null) {
                    System.out.println("Student not found!");
                } else {
                    system.removeStudent(id);
                    System.out.println("Student removed successfully!");
                }
            } else if (choice == 3) {
                System.out.print("Enter student ID: ");
                String id = scanner.next();

                Student student = system.getStudent(id);

                if (student == null) {
                    System.out.println("Student not found!");
                } else {
                    System.out.println("Name: " + student.getName());
                    System.out.println("Age: " + student.getAge());
                    System.out.println("ID: " + student.getId());
                }
            } else if (choice == 4) {
                system.printStudents();
            } else if (choice == 5) {
                System.out.println("Exiting the program...");
                break;
            } else {
                System.out.println("Invalid choice! Please enter a valid choice.");
            }
        }
    }
}

