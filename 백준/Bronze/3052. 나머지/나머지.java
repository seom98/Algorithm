import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<>();

        while (sc.hasNextInt()) {
            input.add(sc.nextInt());
        }

        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            num.add(input.get(i) % 42);
        }

        Set<Integer> test = new HashSet<>(num);
        System.out.println(test.size());
    }
}
