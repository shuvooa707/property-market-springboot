package pondit;

public class StringBuilderPractice {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("Hello");


        // uppercase
        System.out.println( stringBuilder.toString().toUpperCase() );
        // lowercase
        System.out.println( stringBuilder.toString().toLowerCase() );
        // reverse
        System.out.println( stringBuilder.reverse() );
        // find length
        System.out.println( stringBuilder.length() );
        //find the index of 'e'
        System.out.println( stringBuilder.indexOf("e") );
        //find the index of 'l'
        System.out.println( stringBuilder.indexOf("l") );
        //find substring from index 1 to 3
        System.out.println( stringBuilder.substring(1,3) );
        //replace 'l' with 'm'
        System.out.println( stringBuilder.toString().replace('l', 'm') );
        //replace vs replaceAll
        System.out.println( stringBuilder.toString().replaceAll("l", "m") );
        //split it by ' '
        System.out.println( stringBuilder.toString().split(" ") );
        //trim it
        System.out.println( stringBuilder.toString().trim() );
        //concat it with " world" (with method)
        System.out.println( stringBuilder.append(" world") );
        //contains
        System.out.println( stringBuilder.toString().contains("world") );
        //equals
        System.out.println( stringBuilder.toString().equals("hello world") );
        //equalsIgnoreCase
        System.out.println( stringBuilder.toString().equalsIgnoreCase("hello world") );
        //compareTo
        System.out.println( stringBuilder.toString().compareTo("ello wor") );
        // == vs equals
        System.out.println( stringBuilder.toString() == "Hello world" );
        //difference between isBlank and isEmpty
        System.out.println( stringBuilder.toString().isBlank() );
        System.out.println( stringBuilder.toString().isEmpty() );
        //starts with, ends with
        System.out.println( stringBuilder.toString().startsWith("Hello") );
        System.out.println( stringBuilder.toString().endsWith("world") );
    }
}
