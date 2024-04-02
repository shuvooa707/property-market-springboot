package sdlc;

import java.util.Collections;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PredicateTest {
    public static void main(String[] args) {

        String fruit = "Apple";
        IntStream intStreamOfChar = fruit.chars();

        Predicate<Character> isVowel = c -> (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? true : false;

        String apple = intStreamOfChar
                         .mapToObj(ic -> (char) ic)
                         .collect(Collectors.toSet())
                         .stream()
                         .mapToInt(ic ->  ic)
                         .mapToObj(Character.class::cast)
                         .filter(isVowel)
                         .mapToInt(ic -> ic)
                         .mapToObj(ic -> "" + (char)ic)
                         .map(String::toUpperCase)
                         .reduce("", (left, right) -> left + right );

        System.out.println(apple.toUpperCase());

    }
}



interface IsVowelInterface<T> extends Predicate<T> {
    boolean apply(char c);
}