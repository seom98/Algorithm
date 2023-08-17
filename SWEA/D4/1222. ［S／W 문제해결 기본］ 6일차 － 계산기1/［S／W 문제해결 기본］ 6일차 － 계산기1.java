import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			Stack<Character> stack = new Stack<>();
			StringBuilder sb = new StringBuilder();
			int N = sc.nextInt();
			String add = sc.next();;
			for (int i = 0; i < N; i++) {
				char ca = add.charAt(i);
				if (ca == '+') {
					stack.add(ca);
				} else {
					if (stack.isEmpty())
						sb.append(ca);
					else {						
						sb.append(ca);
						sb.append(stack.pop());
					}
				}
			}
			Stack<Integer> stack2 = new Stack<>();
			String ad = sb.toString();
			for (int i = 0; i < N; i++) {
				int ca = ad.charAt(i) - '0';
				if (ad.charAt(i) == '+') {
					int b = stack2.pop();
					int a = stack2.pop();
					stack2.add(a+b);
				} else 
					stack2.add(ca);
			}
			System.out.println("#" + tc + " " + stack2.peek());
		}
	}
}