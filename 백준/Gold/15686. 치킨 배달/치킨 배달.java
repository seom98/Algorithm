import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N, M, ans = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[][] arr;
	static List<int[]> chic, home;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][N];
		chic = new ArrayList<>();
		home = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 1)
					home.add(new int[] { i, j });
				else if (arr[i][j] == 2)
					chic.add(new int[] { i, j });
			}
		}
		visited = new boolean[chic.size()];
		DFS(0, 0);
		System.out.println(ans);
		sc.close();
	}

	static void DFS(int start, int count) {
		if (count == M) {
			min();
			return;
		}
		for (int i = start; i < chic.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				DFS(i + 1, count + 1);
				visited[i] = false;
			}
		}
	}

	static void min() {
		int sumDis = 0;
		for (int i = 0; i < home.size(); i++) {
			int minDis = Integer.MAX_VALUE;
			for (int j = 0; j < chic.size(); j++) {
				if (visited[j]) {
					int dis = Math.abs(home.get(i)[0] - chic.get(j)[0])
							+ Math.abs(home.get(i)[1] - chic.get(j)[1]);
					if (minDis > dis) minDis = dis;
				}
			}
			sumDis += minDis;
		}
		if (ans > sumDis) ans = sumDis;
	}
}