import java.util.*;

public class Main {

	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };
	static char[][] arr;
	static int N, M, count;
	static boolean[][] visited;

	public static void main(String[] e) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t< T; t++) {	
			count = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new char[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++)
				arr[i] = sc.next().toCharArray();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == '#' && !visited[i][j]) {
						visited[i][j] = true;
						dfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
		sc.close();
	}
	
	static void dfs(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int x = i + drow[d];
			int y = j + dcol[d];
			if (x >= 0 && y >= 0 && x < N && y < M && !visited[x][y] && arr[i][j] == '#') {
				visited[x][y] = true;
				dfs(x, y);
			}
		}
	}
}