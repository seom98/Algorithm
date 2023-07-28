import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < num; i++) {
            int a = sc.nextInt();
            if (a == 0) {
                stack.pop();
            } else stack.push(a);
        }

        int sum = 0;
        while (true) {
            if (stack.isEmpty()) break;
            sum += stack.pop();
        }
        System.out.print(sum);
    }
}
