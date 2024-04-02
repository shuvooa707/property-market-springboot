package pondit.contest2;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class BitPlusPlus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        AtomicInteger finalValue = new AtomicInteger();
        finalValue.set(0);

        IntStream
          .range(0, Integer.parseInt(line))
          .forEach(l -> {
              String nextLine = scanner.nextLine();
              if (nextLine.equals("X++")) {
                  finalValue.set( finalValue.get() + 1);
              }
              if (nextLine.equals("--X")) {
                  finalValue.set( finalValue.get() - 1);
              }
          });

        System.out.println(finalValue.get());
    }
}
