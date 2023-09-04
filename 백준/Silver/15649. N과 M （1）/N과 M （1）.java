import java.util.Scanner;

public class Main {

	public static int[] nums;// 배열
	public static int N, M; // 원소수
	public static int[] result; // 결과저장
	public static boolean[] visited; // 해당 원소 사용 유무
	public static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N];
		for (int i = 1; i <= N; i++) {
			nums[i - 1] = i;
		}
		M = sc.nextInt();
		result = new int[N];
		visited = new boolean[N];
		sb = new StringBuilder();
		perm(0);
		System.out.println(sb);
		sc.close();
	}

	public static void perm(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		// 사용할 수 있는 모든 원소를 쳌 하겠다.
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				result[idx] = nums[i]; // 해당 i번째의 원소를 저장
				visited[i] = true; // i번째 원소 사용했다고 표시
				perm(idx + 1);
				visited[i] = false; // i번째 원상복구
			}
		}
	}
}