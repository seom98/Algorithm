import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			graph = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
			}

			max = Integer.MIN_VALUE;
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			for (int i = 1; i <= N; i++) {
				visit = new boolean[N + 1];
				DFS(i, 1);
			}
			System.out.println("#" + tc + " " + max);
		}

	}

	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visit;
	static int max;

	static void DFS(int index, int count) {
		visit[index] = true;
		max = Math.max(max, count);

		for (int i : graph.get(index)) {
			if (!visit[i]) {
				DFS(i, count + 1);
				visit[i] = false;
			}
		}
	}
}