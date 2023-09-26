import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, endX, endY;
	static int arr[][];
	static int[] drow = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] dcol = { -1, 1, 2, 2, 1, -1, -2, -2 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			int startX = sc.nextInt();
			int startY = sc.nextInt();
			endX = sc.nextInt();
			endY = sc.nextInt();

			BFS(startX, startY);
			System.out.println(startX == endX && startY == endY ? 0 : arr[endX][endY]);
		}
		sc.close();
	}

	static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });

		while (!queue.isEmpty()) {
			int[] dequ = queue.poll();
			for (int d = 0; d < 8; d++) {
				int x = dequ[0] + drow[d];
				int y = dequ[1] + dcol[d];
				
				if (x < N && y < N && x >= 0 && y >= 0 && arr[x][y] == 0) {
					arr[x][y] = arr[dequ[0]][dequ[1]] + 1;
					queue.add(new int[] { x, y });
				}
				
				if (x == endX && y == endY)
					return;
			}
		}
	}
}