import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		// 앞으로 보기편하게 숫자만 있으면 스캐너 쓰기로함.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int tc = 1; tc <= N; tc++) {
			int num = sc.nextInt();

			// 스택정의
			Stack<Integer> stack = new Stack<Integer>();

			// num만큼 for문 돎.
			for (int i = 0; i < num; i++) {
				int a = sc.nextInt();

				// a가 0이면 pop
				if (a == 0) {
					if (stack.isEmpty())
						stack.push(a);
					else
						stack.pop();
				}

				// a가 자연수면 push
				else
					stack.push(a);
			}

			// 이제부터 하나씩 더해야함.
			int sum = 0;
			while (true) {
				// 스택이 비어있으면 브레이크 (1)
				if (stack.isEmpty())
					break;

				// pop한걸 하나씩 더함. (2)
				sum += stack.pop();
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}