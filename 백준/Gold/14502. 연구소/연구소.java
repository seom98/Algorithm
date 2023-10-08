import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, safe = 0, max = 0;
    static int[][] arr, copyArr;
    static int[][] select;
    static boolean[] visited;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static List<int[]> list;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로
        arr = new int[N][M]; //블록 배열
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    list.add(new int[]{i, j});
                    safe++;
                }
            }
        }
        select = new int[3][2];
        visited = new boolean[safe];
        combination(0, 0);

        System.out.print(max);

    }
    static void combination(int start, int depth) {
        if (depth == 3) {
            copyArr = new int[N][M];
            for (int i = 0; i < N; i++)
                copyArr[i] = Arrays.copyOf(arr[i], M);
            for (int i = 0; i < 3; i++)
                copyArr[select[i][0]][select[i][1]] = 1;
            bfs();
            return;
        }

        for (int i = start; i < safe; i++) {
            if (!visited[i]) {
                visited[i] = true;
                select[depth][0] = list.get(i)[0];
                select[depth][1] = list.get(i)[1];
                combination(i, depth+1);
                visited[i] = false;
            }
        }
    }
    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int temp = safe-3;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyArr[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int pollX = poll[0];
            int pollY = poll[1];

            for (int d = 0; d < 4; d++) {
                int X = pollX + dRow[d];
                int Y = pollY + dCol[d];
                if (X < N && Y < M && X >= 0 && Y >= 0 && copyArr[X][Y] == 0) {
                    queue.add(new int[] {X, Y});
                    copyArr[X][Y] = 2;
                    temp--;
                }
            }
        }
        if (max < temp) max = temp;
    }
}