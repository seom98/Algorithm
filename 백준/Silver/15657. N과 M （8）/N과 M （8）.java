import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int[] nums;
	public static int N, M;
	public static int[] result;
	public static boolean[] visited;
	public static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		for (int i = 1; i <= N; i++)
			nums[i - 1] = sc.nextInt();
		Arrays.sort(nums);
		result = new int[M];
		visited = new boolean[N];
		sb = new StringBuilder();
		NandM(0, 0);
		System.out.println(sb);
		sc.close();
	}

	static void NandM(int start, int depth) {
		if (depth == M) {
			boolean flag = true;
			for (int i = 1; i < M; i++) {
				if (result[i - 1] > result[i])
					flag = false;
			}
			if (flag) {
				for (int i = 0; i < M; i++) {
					sb.append(result[i]).append(" ");
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			result[depth] = nums[i];
			NandM(i, depth + 1);
		}
	}
}