import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	static int N;
	static int M;
	static char[] arr; // 입력된 숫자들을 저장할 배열
	static boolean[] visited; // 해당 숫자가 선택되었는지 여부를 저장할 배열
	static char[] result; 
	static StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder
	static Set<Character> aeiou;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		aeiou = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

		arr = new char[M]; // 숫자 배열 초기화
		for (int i = 0; i < M; i++)
			arr[i] = sc.next().charAt(0);
		
		Arrays.sort(arr);

		result = new char[N]; // 결과 배열 초기화
		visited = new boolean[M]; // 방문 여부 배열 초기화
		str(0, 0);
		System.out.println(sb);
		sc.close();
		
	}

	static void str(int start, int depth) {
		if (depth == N) {
			int c1 = 0;
			int c2 = 0;
			for (char element : result) {
				if (aeiou.contains(element)) {
					c1++;
				} else
					c2++;
			}
			if (c1 >= 1 && c2 >= 2) {
				for (char element : result)
					sb.append(element);
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < M; i++) {
			if (!visited[i]) { // 해당 숫자가 선택되지 않았다면
				visited[i] = true; // 선택 처리
				result[depth] = arr[i]; // 결과 배열에 넣음
				str(i, depth + 1); // 다음 번호 선택으로 재귀 호출
				visited[i] = false; // 선택 처리 취소 (백트래킹)
			}
		}
	}
}