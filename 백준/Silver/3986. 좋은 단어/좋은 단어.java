import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < num; i++) {
            String goodString = br.readLine();
            if (goodString.length() % 2 == 0) {

                for (int j = 0; j < goodString.length(); j++) {
                    char goodPeek = stack.isEmpty() ? '놉' : stack.peek();
                    char goodPush = stack.push(goodString.charAt(j));
                    if (goodPush == goodPeek) { stack.pop(); stack.pop(); }
                }
                if (stack.isEmpty()) cnt++;
                else stack.clear();
            }
        }
        System.out.print(cnt);
    }
}