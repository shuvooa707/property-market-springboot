package pondit.contest2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class BeautifulMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AtomicInteger x = new AtomicInteger(0);
        AtomicInteger y = new AtomicInteger(0);

        IntStream
          .range(1, 6)
          .forEach(i -> {
              String line = scanner.nextLine();
              AtomicInteger finalJ = new AtomicInteger(0);
              Arrays
                .asList(line.split(" "))
                .forEach(z -> {
                    finalJ.incrementAndGet();
                    if ( !z.equals("0") ) {
                        x.set(i);
                        y.set(finalJ.intValue());
                    }
                });
          });


        int r = (x.get() > 3 ? ( x.get() - 3 ) : ( 3 - x.get() )) + (y.get() > 3 ? ( y.get() - 3 ) : ( 3 - y.get() ));
        System.out.println(r);
    }
}
