import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			String str = sc.next();

			Stack<Character> stack = new Stack<>();
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < N; i++) {
				char c = str.charAt(i);
				
				if (c >= '0' && c <= '9')
					sb.append(c);
				else if (c == '(')
					stack.push(c);
				else if (c == ')') {
					while (stack.peek() != '(')
						sb.append(stack.pop());
					stack.pop();
				}
				
				else {
					if (stack.isEmpty()) {
						stack.push(c);
					} else {
						if (pri(c) > pri(stack.peek()))
							stack.push(c);
						else {
							while (!(stack.isEmpty() || (pri(c) > pri(stack.peek()))))
								sb.append(stack.pop());
							stack.push(c);
						}
					}
				}
			}

			while (!stack.isEmpty())
				sb.append(stack.pop());

			String str2 = sb.toString();
			Stack<Integer> calc = new Stack<>();

			for (int i = 0; i < str2.length(); i++) {
				char c = str2.charAt(i);

				//숫자일때 
				if (c >= '0' && c <= '9')
					calc.push(c - '0');
				
				//숫자아닐때 
				else {
					int a = calc.pop();
					int b = calc.pop();
					int result = 0;
					if (c == '+')
						result = b + a;
					else if (c == '*')
						result = b * a;
					else if (c == '-')
						result = b - a;
					else if (c == '/')
						result = b / a;
					calc.push(result);
				}

			}

			System.out.println("#" + tc + " " + calc.pop());

		}

	}

	public static int pri(char c) {
		if (c == '(' || c == ')')
			return 0;
		else if (c == '+' || c == '-')
			return 1;
		else if (c == '*' || c == '/')
			return 2;
		return -1;
	}
}