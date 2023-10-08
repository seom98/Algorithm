import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N, M, bestCount, bestZeroCount, bestRow, bestCol;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static List<int[]> bestList;
    static List<int[]> list;
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //블록배열의 한칸
        M = Integer.parseInt(st.nextToken()); //블록 종류
        arr = new int[N][N]; //블록 배열
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int point = 0; //점수
        while (true) {
            bestCount = 0;
            bestZeroCount = 0;
            bestRow = 0;
            bestCol = 0;
            bestList = new ArrayList<>();

            for (int m = 1; m <= M; m++) {
                visited = new boolean[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] == m && !visited[i][j])
                            BFS(m, i, j);
                    }
                }
            }
            if (bestCount == 1 || bestCount == 0)
                break;
            point += Math.pow(bestList.size(), 2);
            for (int[] e : bestList) arr[e[0]][e[1]] = -2;
            gravity();
            turn();
            gravity();
        }
        System.out.print(point);
    }
    static void BFS(int m, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        list = new ArrayList<>();
        queue.add(new int[] {i, j});
        list.add(new int[] {i, j});
        visited[i][j] = true;
        int count = 1;
        int zeroCount = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int pollX = poll[0];
            int pollY = poll[1];

            for (int d = 0; d < 4; d++) {
                int X = pollX + dRow[d];
                int Y = pollY + dCol[d];
                if (X < N && Y < N && X >= 0 && Y >= 0 && !visited[X][Y] && (arr[X][Y] == 0 || arr[X][Y] == m)) {
                    queue.add(new int[] {X, Y});
                    list.add(new int[] {X, Y});
                    visited[X][Y] = true;
                    count++;
                    if (arr[X][Y] == 0)
                        zeroCount++;
                }
            }

            if (bestCount < count)
                change(count, zeroCount, i, j);
            else if (bestCount == count) {
                if (bestZeroCount < zeroCount)
                    change(count, zeroCount, i, j);
                else if (bestZeroCount == zeroCount) {
                    if (bestRow < i)
                        change(count, zeroCount, i, j);
                    else if (bestRow == i) {
                        if (bestCol < j)
                            change(count, zeroCount, i, j);
                    }
                }
            }
        }
    }
    static void change(int c, int z, int i, int j) {
        bestCount = c;
        bestZeroCount = z;
        bestRow = i;
        bestCol = j;
        bestList = list;
    }
    static void turn() {
        int[][] turnArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                turnArr[i][j] = arr[j][N-i-1];
        }
        arr = turnArr;
    }
    static void gravity() {
        for (int i = N-2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] > -1 && arr[i+1][j] == -2) {
                    for (int k = i+1; k < N; k++) {
                        if (arr[k][j] == -2) {
                            arr[k][j] = arr[k-1][j];
                            arr[k-1][j] = -2;
                        } else
                            break;
                    }
                }
            }
        }
    }
}