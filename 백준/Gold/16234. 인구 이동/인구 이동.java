import java.io.*;
import java.util.*;

public class Main {
	
    static int N, minInterval, maxInterval;
    static int[][] arr;
    static boolean[][] visited;
    static boolean flag;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        minInterval = Integer.parseInt(st.nextToken());
        maxInterval = Integer.parseInt(st.nextToken());
        
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        
        int day = 0;
        while (true) {
            visited = new boolean[N][N];
            flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j])
                        bfs(i,j);
                }
            }
            if (flag) day++;
            else break;
        }
        System.out.println(day);
    }
    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        queue.add(new int[] {i, j});
        list.add(new int[] {i, j});
        int sum = arr[i][j];
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int pollX = poll[0];
            int pollY = poll[1];

            for (int d = 0; d < 4; d++) {
                int X = pollX + dRow[d];
                int Y = pollY + dCol[d];
                if (X < N && Y < N && X >= 0 && Y >= 0 && !visited[X][Y]) {
                	int interval = Math.abs(arr[X][Y] - arr[pollX][pollY]);
                	if (interval >= minInterval && interval <= maxInterval) {                		
                		queue.add(new int[] {X, Y});
                		list.add(new int[] {X, Y});
                		sum += arr[X][Y];
                		visited[X][Y] = true;
                	}
                }
            }
        }
        if (list.size() > 1) {
            int avg = sum/list.size();
            for (int s = 0; s < list.size(); s++)
                arr[list.get(s)[0]][list.get(s)[1]] = avg;
            flag = true;
        }
    }
}