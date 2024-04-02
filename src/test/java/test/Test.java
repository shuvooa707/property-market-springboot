package test;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.lang.System.*;

import static java.lang.System.err;
import static java.lang.System.out;

public class Test {
    public static void main(String[] args) {
//        ArrayList<Student> students = new ArrayList<>();
//
//        students.add(new Student(19, "Tony"));
//        students.add(new Student(24, "Jony"));
//        students.add(new Student(24, "Dick"));
//        students.add(new Student(26, "Andy"));
//        students.add(new Student(30, "Lia"));
//        students.add(new Student(30, "Mia"));
//
//        Map<Integer, List<Student>> studentMap = students
//                                                   .stream()
//                                                   .collect(Collectors.groupingBy(s -> s.getName().length()));
//
//        out.println(studentMap);


//        out.println(LocalDate.now().toEpochDay());

        Long start = System.currentTimeMillis();
        /** String to Chars **/
        String fruit = IntStream
                         .range(0, 9999999)
                         .mapToObj(c -> String.valueOf((char)(Math.random() * 110)) )
                         .collect(Collectors.joining(""));

        Map<String, List<String>> fruitMap = fruit
                                               .chars()
                                               .mapToObj(c -> String.valueOf((char) c))
                                               .collect(
                                                 Collectors.groupingBy(c -> c, Collectors.toList())
                                               );

        out.println(System.currentTimeMillis() - start);
    }

    public static void print(Consumer<Integer> consumer) {

        consumer.accept(5);
    }
}

class LinkedList<T> {

    Node<T> head = null;
    Node<T> tail = null;

    Integer nodes = 0;

    private class Node<T> {
        T value;
        Node<T> next = null;

        Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" +
                     "  Value: " + nodes +
                     "}";
        }
    }


    /**
     * Add Element to the head of the list
     **/
    public void add(T value) {

        this.nodes++;

        Node<T> newNode = new Node<T>(value);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(T value) {

        this.nodes++;
        Node<T> newNode = new Node<T>(value);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            newNode.next = null;
            tail = newNode;
        }
    }


    public T get() {
        return head.value;
    }

    public T get(int index) {
        Node<T> node = head;
        if (node == null) return null;
        while (index > 1) {
            index--;
            node = node.next;
            if (node == null) return null;
        }
        return node.value;
    }
}

@Data
@AllArgsConstructor
class Student {
    private int age;
    private String name;
}