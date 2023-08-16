import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= N; tc++) {
			// 괄호 하나씩 짤라서 배열에 넣음
			String[] Goalho = br.readLine().split("");
			// 그냥 숫자로 풀려면 아래 대신에 int stack = 0;
			Stack<String> stack = new Stack<>();
			// 조각난 쇠막대기 개수를 count
			int count = 0;
			for (int i = 0; i < Goalho.length; i++) {
				// 만약에 ( 가 오면 그 다음이 (인지 )인지 판별해야함.
				if (Goalho[i].equals("(")) {
					// 마지막은 어차피 )가 올꺼라서 i+1 이 배열길이보다 큰지는 판별 안해도됨.
					if (Goalho[i + 1].equals(")")) {
						// 암튼 (바로다음에 )가 오면 컷팅시작인거임.
						// 앞에서 생성된 쇠막대기 갯수만큼 조각나는거임.
						// 숫자로 풀면 count += stack;
						count += stack.size();
						// i번째를 보면서 바로다음의 i+1번째도 봤으니까 넘어가야하니까 i++;
						i++;
					} else {
						// (다음에 (가 왔다는건 새로운 막대기가 생성됐다는 뜻.
						// 숫자로 풀면 stack++;
						stack.push("(");
					}
				} else {
					// )가 나왔다는 건 막대기의 끝이라는 뜻이니까 잘릴 막대기후보에서 떨어져나감.
					// 숫자로 풀면 stack--;
					stack.pop();
					// 떨어져나간 1개를 조각난 막대기개수에 추가해줌.
					count++;
				}
			}

			System.out.println("#" + tc + " " + count);
		}
	}
}