package pondit.collection;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1, 121);
//        map.put(2, 2121);
//        var entries = map.entrySet();
//        entries
//          .stream()
//          .forEach( (Map.Entry<Integer, Integer> entry) -> {
//                System.out.println(entry.getKey());
//          });
//
//        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(entries);
//        System.out.println(entryList);


        Arrays
          .stream(distributeShirts(8, 157))
          .forEach(System.out::println);
    }


    public static int[] distributeShirts(int bags, int shirts) {
        int[] bagsArray = new int[bags];

        int unEven = shirts % bags;
        Arrays.fill(bagsArray, shirts / bags);
        if ( unEven == 0 ) {
            return bagsArray;
        }

//        for (int i = 0; i < bags; i++) {
//            bagsArray[i] += unEven > 0 ? 1 : 0;
//            unEven--;
//        }

        bagsArray[0] += unEven;
        
        return bagsArray;
    }
}
