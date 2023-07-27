import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int P = 0;
        int conut = 0;
        for (int i = 0; i < N; i++) {
            if (stack.peek() > P ) {
                conut++;
                P = stack.peek();
            }
            stack.pop();
        }
        System.out.print(conut);

    }
}