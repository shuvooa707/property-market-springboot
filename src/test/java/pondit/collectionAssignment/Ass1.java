package pondit.collectionAssignment;

import lombok.Data;
import org.glassfish.jaxb.core.util.Which;
import org.springframework.data.domain.Page;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Ass1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LinkedHashMap<Integer, List<Student>> grades = new LinkedHashMap<>();

        grades = loadData();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Find Student");
            System.out.println("0. Exit");
            System.out.print("-> ");
            int option = Integer.valueOf(scanner.nextLine());
            switch (option) {
                case 1: {
                    addStudent(grades);
                    System.out.println(" Student Added ");
                    saveToFile(grades);
                    break;
                }
                case 2: {
                    viewAllstudents(grades);
                    break;
                }
                case 3: {
                    System.out.print("\n Enter Student Name: ");
                    String name = scanner.nextLine();
                    Optional<Student> studentOptional = findStudent(grades, name);
                    studentOptional.ifPresentOrElse(student -> {
                          System.out.println(student.toString());
                      },
                      () -> {
                          System.out.println("Student Not Found");
                      });

                    break;
                }
                case 0: {
                    return;
                }
            }
        }
    }

    private static LinkedHashMap<Integer, List<Student>> loadData() throws ClassNotFoundException, IOException {
        Path path = Path.of("/home/shuvo/Desktop/code/java/PropertyMarket/src/test/java/pondit/collectionAssignment/file");
        FileInputStream fileInputStream = new FileInputStream(String.valueOf(path));
        LinkedHashMap<Integer, List<Student>> grades;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            grades = (LinkedHashMap<Integer, List<Student>>) objectInputStream.readObject();
        } catch (IOException exception) {
            return new LinkedHashMap<Integer, List<Student>>();
        }
        return grades;
    }


    public static void addStudent(LinkedHashMap<Integer, List<Student>> grades) {
        System.out.println("-------------Enter Student Details---------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.valueOf(scanner.nextLine());
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter score: ");
        int score = scanner.nextInt();
        System.out.print("Enter grade: ");
        int grade = scanner.nextInt();

        if (grades.containsKey(grade)) {
            var studentList = grades.get(grade);
            studentList.add(new Student(name, age, gender, score));
        } else {
            var studentList = new LinkedList<Student>();
            studentList.add(new Student(name, age, gender, score));
            grades.put(grade, studentList);
        }
    }

    public static void viewAllstudents(LinkedHashMap<Integer, List<Student>> grades) {
        System.out.println("-------------- Listing All Students ------------------");
        AtomicInteger index = new AtomicInteger();
        index.set(0);
        grades
          .entrySet()
          .stream()
          .forEach(grade -> {
              grade
                .getValue()
                .stream()
                .forEach(student -> {
                    System.out.println(student.toString());
                });
          });
    }

    public static Optional<Student> findStudent(LinkedHashMap<Integer, List<Student>> grades, String name) {
        List<Student> students = new ArrayList<>();
        grades
          .entrySet()
          .stream()
          .forEach(grade -> {
              grade
                .getValue()
                .stream()
                .forEach(student -> {
                    students.add(student);
                });
          });

        return students
                 .stream()
                 .filter(student -> student.getName().equals(name))
                 .findFirst();
    }


    public static void saveToFile(LinkedHashMap<Integer, List<Student>> grades) throws IOException, ClassNotFoundException {
        Path path = Path.of("/home/shuvo/Desktop/code/java/PropertyMarket/src/test/java/pondit/collectionAssignment/file");
        FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(path));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(grades);
        objectOutputStream.close();
    }
}


@Data
class Student implements Serializable {
    Student(String name, int age, String gender, int score) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.score = score;
    }

    private String name;
    private int age;
    private String gender;
    private int score;

    @Override
    public String toString() {
        return "{" +
                 "\n\tname: " + name +
                 "\n\tage: " + age +
                 "\n\tgender: " + gender +
                 "\n\tscore: " + score +
                 "\n}";
    }
}