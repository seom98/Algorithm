import java.util.Scanner;

public class Main {

	static int N, M, ans = 0;
	static int[][] arr;
	static boolean[] visited = new boolean[26];
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++)
				arr[i][j] = str.charAt(j) - 'A';
		}
		
		alpabet(0, 0, 0);
		
		System.out.println(ans);
		sc.close();
	}

	public static void alpabet(int i, int j, int count) {
		if (visited[arr[i][j]]) {
			if (ans < count) ans = count;
			return;
		} else {
			for (int d = 0; d < 4; d++) {
				int x = i + drow[d];
				int y = j + dcol[d];

				if (x >= 0 && y >= 0 && x < N && y < M) {
					visited[arr[i][j]] = true;
					alpabet(x, y, count + 1);
					visited[arr[i][j]] = false;
				}
			}
		}
	}
}