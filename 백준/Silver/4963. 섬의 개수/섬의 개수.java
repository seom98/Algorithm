import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] dRow = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dCol = {1, 0, -1, 0, 1, -1, 1, -1};
    static boolean[][] visited;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            M = sc.nextInt();
            N = sc.nextInt();
            if (N == 0 && M == 0)
                return;
            arr = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++)
                    arr[i][j] = sc.nextInt();
            }
            int day = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        day++;
                        bfs(i, j);
                    }
                }
            }
            System.out.println(day);
        }
    }
    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int pollX = poll[0];
            int pollY = poll[1];
            for (int d = 0; d < 8; d++) {
                int x = pollX + dRow[d];
                int y = pollY + dCol[d];
                if (x >= 0 && y >= 0 && x < N && y < M && arr[x][y] == 1 && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new int[] {x, y});
                }
            }
        }
    }
}