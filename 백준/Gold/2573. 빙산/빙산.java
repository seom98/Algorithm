import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int c = 0;
		while (true) {
			visited = new boolean[N][M];
			int a = 0;
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < M-1; j++) {
					if (arr[i][j] != 0 && !visited[i][j]) {
						a++;
						visited[i][j] = true;
						DFS(i, j);
					}
				}
			}
			if (a > 1) {
				break;
			}
			if (a == 0) {
				System.out.println(0);
				return;
			}
			c++;
			int[][] count = new int[N][M];
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < M-1; j++) {
					if (arr[i][j] != 0) {
						if(arr[i-1][j] == 0) {
							count[i][j]++;
						}
						if(arr[i+1][j] == 0) {
							count[i][j]++;
						}
						if(arr[i][j-1] == 0) {
							count[i][j]++;
						}
						if(arr[i][j+1] == 0) {
							count[i][j]++;
						}
					}
				}
			}
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < M-1; j++) {
					if (count[i][j] != 0) {						
						arr[i][j] -= count[i][j];
						if (arr[i][j] < 0) arr[i][j] = 0;
					}
				}
			}
		}
		System.out.println(c);
	}
	
	public static void DFS(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int x = i + drow[d];
			int y = j + dcol[d];
			if (arr[x][y] != 0 && !visited[x][y]) {				
				visited[x][y] = true; 
				DFS(x, y);
			}
		}
	}
}