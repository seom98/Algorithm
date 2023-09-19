import java.util.Scanner;

public class Solution {
	
	static int N, max, min, num;
	static int[][] arr;
	static boolean[][] visited;
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t<=T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j] > max) max = arr[i][j];
					if (arr[i][j] < min) min = arr[i][j];
				}				
			}
			int maxCount = 0;
			for (int k = min-1; k < max; k++) {	
				visited = new boolean[N][N];
				num = k;
				int count = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (arr[i][j] > k && visited[i][j] == false) {
							count++;
							DFS(i, j);
						}
					}
				}
				if (maxCount < count) maxCount = count;
			}
			System.out.println("#" + t + " " + maxCount);
		}
		sc.close();
	}
	public static void DFS(int i, int j) {
		visited[i][j] = true;
		
		for (int d = 0; d < 4; d++) {
			int x = i + drow[d];
			int y = j + dcol[d];

			if (x >= 0 && x < N && y >= 0 && y < N && arr[x][y] > num && visited[x][y] == false)
				DFS(x, y);
		}
	}
}