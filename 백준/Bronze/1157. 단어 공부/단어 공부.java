import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String input = sc.next();
        String[] string = input.toUpperCase().split("");
        Map<String, Integer> counter = new HashMap<>();
        int max = 0;
        int count = 0;

        for (String name : string) {
            if (counter.containsKey(name)) {
                counter.put(name, counter.get(name) + 1);
            } else {
                counter.put(name, 1);
            }
        }

        for (String M : counter.keySet()) {
            if (counter.get(M) > max) {
                max = counter.get(M);
            }
        }

        for (String M : counter.keySet()) {
            if (counter.get(M) == max) {
                count += 1;
            }
        }

        if (count > 1) {
            System.out.println("?");
        } else {
            for (String M : counter.keySet()) {
                if (counter.get(M) == max) {
                    System.out.println(M);
                }
            }
        }
    }
}