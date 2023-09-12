import java.util.Scanner;

public class Main {
	static int N, M;
	static int max = 0;
	static int[][] arr;
	static boolean[][] visited;
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };
	static int[] drow2 = { -1, 1, 0, 0, 1, 1, -1, -1 };
	static int[] dcol2 = { 0, 0, -1, 1, 1, -1, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				DFS(i, j, 1, arr[i][j], 0);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
		sc.close();
	}
	static void DFS(int i, int j, int dep, int sum, int drdc) {
		if (dep == 4) {
			if (max < sum) max = sum;
			return;
		}
		
		if (dep == 1) {			
			for (int d = 0; d < 8; d++) {
				int x = i + drow2[d];
				int y = j + dcol2[d];
				
				if (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y]) {
					visited[x][y] = true;
					DFS(x, y, dep+1, sum+arr[x][y], d);
					visited[x][y] = false;
				}
			}
		}
		else if (dep == 2 && drdc >= 4) {
			if (drdc == 4) {
				visited[i-1][j] = true;
				DFS(i-1, j, dep+1, sum+arr[i-1][j], drdc);
				visited[i-1][j] = false;
				
				visited[i][j-1] = true;
				DFS(i, j-1, dep+1, sum+arr[i][j-1], drdc);
				visited[i][j-1] = false;
			} 
			else if (drdc == 5) {
				visited[i-1][j] = true;
				DFS(i-1, j, dep+1, sum+arr[i-1][j], drdc);
				visited[i-1][j] = false;
				
				visited[i][j+1] = true;
				DFS(i, j+1, dep+1, sum+arr[i][j+1], drdc);
				visited[i][j+1] = false;
			} 
			else if (drdc == 6) {
				visited[i+1][j] = true;
				DFS(i+1, j, dep+1, sum+arr[i+1][j], drdc);
				visited[i+1][j] = false;
				
				visited[i][j-1] = true;
				DFS(i, j-1, dep+1, sum+arr[i][j-1], drdc);
				visited[i][j-1] = false;
			} 
			else if (drdc == 7) {
				visited[i+1][j] = true;
				DFS(i+1, j, dep+1, sum+arr[i+1][j], drdc);
				visited[i+1][j] = false;
				
				visited[i][j+1] = true;
				DFS(i, j+1, dep+1, sum+arr[i][j+1], drdc);
				visited[i][j+1] = false;
			}
		}
		else {
			for (int d = 0; d < 4; d++) {
				int x = i + drow[d];
				int y = j + dcol[d];
				
				if (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y]) {
					visited[x][y] = true;
					DFS(x, y, dep+1, sum+arr[x][y], drdc);
					visited[x][y] = false;
				}
			}
		}
	}
}