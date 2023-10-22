import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dRow = {0, 1, 0, -1};
    static int[] dCol = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1)
                    count++; // 처음에 치즈개수 구해놓고 치즈개수 0이면 멈추게 해야겠다.
            }
        }
        int day = 0;
        while (count != 0) {
            day++;
            int[][] C = new int[N][M];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {0, 0});
            C[0][0] = -1;

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int pollX = poll[0];
                int pollY = poll[1];
                for (int d = 0; d < 4; d++) {
                    int x = pollX + dRow[d];
                    int y = pollY + dCol[d];
                    if (x >= 0 && y >= 0 && x < N && y < M && C[x][y] != -1) {
                        if (arr[x][y] == 0) {
                            C[x][y] = -1;
                            queue.add(new int[] {x, y});
                        } else
                            C[x][y]++;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (C[i][j] > 1) {
                        arr[i][j] = 0;
                        count--;
                    }
                }
            }
        }
        System.out.println(day);
        // 자 일단 그냥 배열이 있고, 카운트를 체크할 배열이 있음.
        // 만들어진 그냥 배열 너비우선 탐색을 하면서 갔다온 자리는 -1로 표시하고 주변에 치즈칸이 있으면 +1씩 해줌.
        // 끝까지 돌고 나면 카운트가 +2 이상 된 친구들만 전부 그냥 배열에서 0으로 바꾸는거임!!
    }
}