import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	private static int N,M;
	private static int[] nums;
	private static int[] result;
	public static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		result = new int[M];
		visited = new boolean[N];
		for (int i=0; i<N; i++)
			nums[i] = sc.nextInt();
		Arrays.sort(nums);
		
		NandM(0);
		System.out.print(sb);
		sc.close();
	}

	private static void NandM(int depth) {
		if (depth == M) {
			for (int i=0; i<M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
		} else {
			int num = 0;
			for (int i=0; i<N; i++) {
				if (num == nums[i]) continue;
				if (!visited[i]) {
					visited[i] = true;
					result[depth] = nums[i];
					NandM(depth + 1);
					visited[i] = false;
					num = nums[i];
				}
			}
		}
	}
}