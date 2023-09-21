import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int M, N, max;
	static int[][] tomato, count;
	static boolean[][] visited;
	static Queue<Point> queue = new LinkedList<>();
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		count = new int[N][M];
		tomato = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				tomato[i][j] = sc.nextInt();
		}
		sc.close();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 1) {
					queue.add(new Point(i, j));
					visited[i][j] = true;
					count[i][j] = 0;
				}
			}
		}

		BFS();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && tomato[i][j] == 0) {
					System.out.print(-1);
					return;
				}
			}
		}
		System.out.print(max);
	}
	public static void BFS() {
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int x = p.x + drow[d];
				int y = p.y + dcol[d];
				
				if (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y] && tomato[x][y] == 0) {
					visited[x][y] = true;
					queue.add(new Point(x, y));
					count[x][y] = count[p.x][p.y] + 1;
					if(max < count[x][y]) max = count[x][y];
				}
			}
		}
	}
}