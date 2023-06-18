import java.util.*;


public class Main {

    public static void main(String[] args) {
        List<String> data = Arrays.asList("Hello", "Bye", "Bye", "Orange","Orange");

        List<String> result = new ArrayList<>();

        data.stream()
                .filter(s -> !s.equals("Bye"))
                .distinct()
                .forEach(s -> result.add(s));

        System.out.println(result);



    }
}