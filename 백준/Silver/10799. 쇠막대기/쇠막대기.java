import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Goalho = br.readLine().split("");
        int stack = 0;
        int count = 0;
        for (int i = 0; i < Goalho.length; i++) {
            if (Goalho[i].equals("(")) {
                if (Goalho[i+1].equals(")")) {
                    count += stack;
                    i++;
                } else {
                    stack++;
                }
            } else {
                stack--;
                count++;
            }
        }

        System.out.print(count);

    }
}