package sdlc;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ObjectCopyPractice {
    public static void main(String[] args) throws SecurityException, IOException {
//        Student student = new Student(1, "Abu", new Address("Dhaka", "Bangladesh", "mirpur 10", 2121L));


        ArrayList<String> arrayList = new ArrayList<>(List.of("apple", "mango"));
        LinkedList<String> linkedList = new LinkedList<>(List.of("apple", "mango"));
        int n = Integer.MAX_VALUE / 100;

        long start = System.currentTimeMillis();
        IntStream
          .range(0, n)
          .forEach(i -> {
              linkedList.add( (int)(linkedList.size() / 3),"anything");
          });
        long end = System.currentTimeMillis();

        System.out.println(" LinkedList Took : " + (end-start));

        start = System.currentTimeMillis();
        IntStream
          .range(0, n)
          .forEach(i -> {
              arrayList.add((int)(arrayList.size() / 3), "anything");
          });
        end = System.currentTimeMillis();

        System.out.println(" ArrayList Took : " + (end-start));
    }
}



@Data
@AllArgsConstructor
class Student implements Serializable {
    int id;
    String name;
    Address address;

    @Override
    public Student clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        return student;
    }


    @Override
    public String toString() {
        return "";
    }
}
@Data
@AllArgsConstructor
class Address {
    String city;
    String country;
    String street;
    Long zip;
}