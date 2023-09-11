import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N][M];
			int K = sc.nextInt();
			for (int k = 0; k < K; k++) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				arr[i][j] = 1;
			}
			int jirung = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1) {
						jirung++;
						DFS(i, j);
					}
				}
			}
			System.out.println(jirung);
		}
		sc.close();
	}
	public static void DFS(int i, int j) {
		arr[i][j] = 10;
		
		for (int d = 0; d < 4; d++) {
			int x = i + drow[d];
			int y = j + dcol[d];

			if (x >= 0 && x < N && y >= 0 && y < M && arr[x][y] == 1)
				DFS(x, y);
		}
	}
}