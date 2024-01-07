import java.util.*;

public class Main {

	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };
	static int[][] arr;
	static int N, M, max, k;
	static boolean[][] visited;

	public static void main(String[] e) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M];
		int L = sc.nextInt();
		for (int i = 0; i < L; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a-1][b-1] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					dfs(i, j);
					if (k > max) {
						max = k;
					}
					k = 0;
				}
			}
		}
		System.out.println(max);

	}
	
	static void dfs(int i, int j) {
		k++;
		
		for (int d = 0; d < 4; d++) {
			int x = i + drow[d];
			int y = j + dcol[d];
			if (x >= 0 && y >= 0 && x < N && y < M && !visited[x][y] && arr[x][y] == 1) {
				visited[x][y] = true;
				dfs(x, y);
			}
		}
		
	}
}