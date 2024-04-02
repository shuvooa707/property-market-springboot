package pondit;

import java.util.List;

public class GenericsTask1 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Double> doubles = List.of(2.0, 1.5, 4.5, 2.5, 1.5);
        sum(integers);
        sum(doubles);
    }


    public static void sum(List<?> numbers) {
        double sumEv = 0;
        double sumOdd = 0;

        for (Object number : numbers) {
            if ( (double)number % 2 == 0 ) {
                sumEv += (double) number;
            } else {
                sumOdd += (double) number;
            }
        }


        System.out.println("Sum of Even Numbers: " + sumEv);
        System.out.println("Sum of odd numbers : " + sumOdd);

//        String firstElementClass = numbers.stream().findFirst().get().getClass().toString();
//
//
//        // if integer
//        if ( Integer.class.toString().equals(firstElementClass)  ) {
//            for (Object number : numbers) {
//                if ( (int)number % 2 == 0 ) {
//                    sumEv += (int) number;
//                } else {
//                    sumOdd += (int) number;
//                }
//            }
//
//            System.out.println("Integer");
//            System.out.println("Sum of Even Numbers: " + (int)sumEv);
//            System.out.println("Sum of odd numbers : " + (int)sumOdd);
//        }
//        // if double
//        if ( Double.class.toString().equals(firstElementClass)  ) {
//            for (Object number : numbers) {
//                if ( (double)number % 2 == 0 ) {
//                    sumEv += (double) number;
//                } else {
//                    sumOdd += (double) number;
//                }
//            }
//
//            System.out.println("Double");
//            System.out.println("Sum of Even Numbers: "+sumEv);
//            System.out.println("Sum of odd numbers : "+sumOdd);
//        }

    }


    public static <T extends Number> void calculateNumberSum(List<T> list){
        double sumEv = 0,sumOdd = 0;

        for(T t :list){
            double a =  t.doubleValue();
            if(a%2==0){
                sumEv=sumEv+a;
            }else{
                sumOdd=sumOdd+a;
            }

        }
        System.out.println("Sum of Even Numbers:"+sumEv);
        System.out.println("Sum of odd numbers :"+sumOdd);
    }
}
