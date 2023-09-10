import java.util.Scanner;

public class Main {
	
	static int N, M, art;
	static int[][] arr;
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int artCount = 0; // 그림의 개수
		int artMax = 0; // 젤 큰 그림의 넓이
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					art = 0;
					artCount++;
					DFS(i, j);
					if (artMax < art) artMax = art;
				}
			}
		}
		System.out.println(artCount + "\n" + artMax);
		sc.close();
	}
	
	public static void DFS(int i, int j) {
		art++;
		arr[i][j] = 10;
		
		for (int d = 0; d < 4; d++) {
			int x = i + drow[d];
			int y = j + dcol[d];

			if (x >= 0 && x < N && y >= 0 && y < M && arr[x][y] == 1) {
				DFS(x, y);
			}
		}
	}
}