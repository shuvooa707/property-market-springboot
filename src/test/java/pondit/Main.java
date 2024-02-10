package pondit;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }

    public static String replaceSpaces(String input) {
        return input.replace(" ", "_");
    }
    public static int CountVowels(String input) {
    return input
             .chars()
             .reduce(0, (left, right) -> {
                 if ( "aeiou".contains(String.valueOf((char) right)) ) return left + 1;
                 return left;
             });
    }
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }
    public static Boolean isPalindrome(String input) {
        int len = input.length();
        for (int i = 0; i < len; i++) {
            if (input.charAt(i) != input.charAt(len-i-1)) return false;
        }
        return true;
    }
    public static String ExtractDigits(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        input
          .chars()
          .forEach(c -> {
              if ( ('9' >= c) && ('0' <= c) ) {
                  stringBuilder.append((char) c);
              }
          });

        return stringBuilder.toString();
    }

//    public static int wordFrequency(String word, String input) {
//        input.split(" ");
//    }
}


enum ConnectionType {
    MYSQL, ORACLE, POSTGRES
}

//abstract class Vehicle {
//    int wheelsCount;
//    boolean hasEngine;
//
//    abstract void move();
//}
//
//class Bus extends Vehicle {
//    Bus(int wheelsCount, boolean hasEngine) {
//        this.wheelsCount = wheelsCount;
//        this.hasEngine = hasEngine;
//    }
//    void move() {
//        System.out.println("Paaay Paaaay!!!!!!");
//    }
//}
//class Rikshaw extends Vehicle{
//    Rikshaw(int wheelsCount, boolean hasEngine) {
//        this.wheelsCount = wheelsCount;
//        this.hasEngine = hasEngine;
//    }
//
//    void move() {
//        System.out.println("Tring Tring!!!!!!");
//    }
//}
//class Car extends Vehicle {
//    Car(int wheelsCount, boolean hasEngine) {
//        this.wheelsCount = wheelsCount;
//        this.hasEngine = hasEngine;
//    }
//    void move() {
//        System.out.println("Pep Pep!!!!!!");
//    }
//}
//class Cycle extends Vehicle {
//    Cycle(int wheelsCount, boolean hasEngine) {
//        this.wheelsCount = wheelsCount;
//        this.hasEngine = hasEngine;
//    }
//    void move() {
//        System.out.println("Tiring Tiring Cycle Chalai!!!!!!");
//    }
//}
//
//
//class Truck extends Bus {
//    Truck(int wheelsCount, boolean hasEngine) {
//        super(wheelsCount, hasEngine);
//    }
//    @Override
//    void move() {
//        System.out.println("Pooooo Poooooooo!!!!!!!!!!");
//    }
//}