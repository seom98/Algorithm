import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static int N, M, min;
    static int[][] arr;
    static int[] MIN;
    static boolean[][] visited;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static List<int[]> list;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            min = Integer.MAX_VALUE;
            arr = new int[N][N];
            visited = new boolean[N][N];
            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                    if (arr[i][j] == 1) {
                        if (i == 0 || i == N-1 || j == 0 || j == N-1) {
                            visited[i][j] = true;
                        } else {
                            list.add(new int[] {i, j});
                            visited[i][j] = true;
                        }
                    }
                }
            }
            M = list.size();
            MIN = new int[M+1];
            Arrays.fill(MIN, Integer.MAX_VALUE);
            DFS(0, 0, M);

            for (int i = M; i >= 0; i--) {
                if(MIN[i] != Integer.MAX_VALUE) {
                    System.out.println("#" + t + " " + MIN[i]);
                    break;
                }
            }

        }


    }
    static void DFS(int dep, int count, int v) {
        if (dep == M) {
            if(MIN[v] > count)
                MIN[v] = count;
            return;
        }
        for (int d = 0; d < 5; d++) {
            if (d == 4) {
                DFS(dep+1, count, v-1);
                return;
            } else {
                int[] now = list.get(dep);
                if (icando(now, d)) {
                    int x = now[0];
                    int y = now[1];
                    while (true) {
                        x += dRow[d];
                        y += dCol[d];

                        if (x >= 0 && y >= 0 && x < N && y < N) {
                            visited[x][y] = true;
                            count++;
                        } else break;
                    }
                    DFS(dep+1, count, v);
                    x = now[0];
                    y = now[1];
                    while (true) {
                        x += dRow[d];
                        y += dCol[d];

                        if (x >= 0 && y >= 0 && x < N && y < N) {
                            visited[x][y] = false;
                            count--;
                        } else break;
                    }
                }
            }
        }
    }
    static boolean icando(int[] now, int d) {
        int x = now[0];
        int y = now[1];

        while (true) {
            x += dRow[d];
            y += dCol[d];
            if (x >= 0 && y >= 0 && x < N && y < N) {
                if (visited[x][y])
                    return false;
            } else return true;
        }
    }
}