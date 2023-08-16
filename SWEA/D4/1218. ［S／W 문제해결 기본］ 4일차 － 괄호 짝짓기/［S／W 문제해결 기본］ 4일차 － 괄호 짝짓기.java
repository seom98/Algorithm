import java.util.Scanner;
import java.util.Stack;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			Stack<Character> stack = new Stack<>();
			String str = sc.next();
			for (int i = 0; i < N; i++) {
				char x = str.charAt(i);
				if (x == '(' || x == '{' || x == '[' || x == '<')
					stack.push(x);
				else {
					if (x == ')') {
						if (stack.peek() == '(') {
							stack.pop();
						} else stack.push(x);
					} else if (x == '}') {
						if (stack.peek() == '{') {
							stack.pop();
						} else stack.push(x);
					} else if (x == ']') {
						if (stack.peek() == '[') {
							stack.pop();
						} else stack.push(x);
					} else if (x == '>') {
						if (stack.peek() == '<') {
							stack.pop();
						} else stack.push(x);
					}
				} 
			}
			
			if (stack.isEmpty()) {
				System.out.println("#" + tc + " " + 1);
			} else
				System.out.println("#" + tc + " " + 0);
			
		}
	}
	
	

	
}