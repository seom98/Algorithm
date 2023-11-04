import java.io.*;
import java.util.*;

public class Solution {

	static int[] dRow = { -1, 1, 0, 0 };
	static int[] dCol = { 0, 0, -1, 1 };

	static class cell {
		int x, y, wait, start, check, life;

		public cell(int x, int y, int wait, int start, int check, int life) {
			this.x = x; // 세로
			this.y = y; // 가로
			this.wait = wait; // 활성화 전
			this.start = start; // 활성화 후
			this.check = check; // 겹치는지
			this.life = life; // 생명력
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 최대 50
			int M = Integer.parseInt(st.nextToken()); // 최대 50
			int K = Integer.parseInt(st.nextToken()); // 최대 300
			int startP = K / 2 + 1;
			Queue<cell> quu = new LinkedList<>();
			cell[][] arr = new cell[N + K + 3][M + K + 3];
			for (int i = startP; i < startP + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = startP; j < startP + M; j++) {
					int life = Integer.parseInt(st.nextToken());
					if (life > 0) {
						arr[i][j] = new cell(i, j, life-1, life, 0, life);
						quu.add(arr[i][j]);
					}
				}
			}
			while (K-- > 0) {
				int size = quu.size();
				Queue<int[]> change = new LinkedList<>();
				for (int s = 0; s < size; s++) {
					cell c = quu.poll();
					int x = c.x, y = c.y, wait = c.wait, start = c.start, life = c.life;

					if (wait >= 0) {
						arr[x][y].wait--;
						if (wait == 0)
							arr[x][y].start--;
						quu.add(arr[x][y]);
					} else if (wait == -1) {
						arr[x][y].start--;
						if (start > 0) quu.add(arr[x][y]);
						for (int d = 0; d < 4; d++) {
							int nx = x + dRow[d];
							int ny = y + dCol[d];
							if (arr[nx][ny] == null) {
								arr[nx][ny] = new cell(nx, ny, life-1, life, 1, life);
								change.add(new int[] { nx, ny, life });
							} else if (arr[nx][ny].check == 1 && arr[nx][ny].life < life) {
								arr[nx][ny].start = life-1;
								arr[nx][ny].wait = life;
								arr[nx][ny].life = life;
								change.add(new int[] { nx, ny, life });
							}
						}
					}
				}
				while (!change.isEmpty()) {
					int[] poll = change.poll();
					int x = poll[0], y = poll[1], life = poll[2];
					if (arr[x][y].life == life) {
						arr[x][y].check = 0;
						quu.add(new cell(x, y, life-1, life, 0, life));
					}
				}
			}
			System.out.println("#" + t + " " + quu.size());
		}
	}
}