package pondit;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class SortedArrayPractice {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        IntStream
          .range(0, 1000)
          .forEach(i->{
              priorityQueue.add((int) (Math.random()*100));
          });

        priorityQueue
          .forEach(i -> {
              System.out.println( priorityQueue.remove() );
          });
    }
}


class PrioritySet<Integer> {

}