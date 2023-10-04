import java.util.Scanner;

public class Main {

	static int R, C, T, sum;
	static int[][] 구사과의방;
	static int[] 공기청정기;
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		구사과의방 = new int[R][C];
		공기청정기 = new int[2];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				구사과의방[i][j] = sc.nextInt();
				if (구사과의방[i][j] == -1) {
					공기청정기[0] = i - 1; // 공기청정기의 위쪽부분
					공기청정기[1] = i; // 공기청정기의 아래쪽부분
				} else
					sum += 구사과의방[i][j];
			}
		}
		int seconds = 0;
		while (seconds++ < T) {
			미세먼지확산();
			미세먼지안녕();
		}
		System.out.println(sum);
		sc.close();
	}

	static void 미세먼지확산() {
		int[][] 일초후구사과의방 = new int[R][C];
		일초후구사과의방[공기청정기[0]][0] = -1;
		일초후구사과의방[공기청정기[1]][0] = -1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (구사과의방[i][j] > 0) {
					일초후구사과의방[i][j] += 구사과의방[i][j];
					int 확산될미세먼지 = 구사과의방[i][j]/5;

					for (int d = 0; d < 4; d++) {
						int x = i + drow[d];
						int y = j + dcol[d];
						if (x >= 0 && y >= 0 && x < R && y < C && 구사과의방[x][y] != -1) {
							일초후구사과의방[x][y] += 확산될미세먼지;
							일초후구사과의방[i][j] -= 확산될미세먼지;
						}
					}
				}
			}
		}
		구사과의방 = 일초후구사과의방;
	}

	static void 미세먼지안녕() {
		sum -= 구사과의방[공기청정기[0]-1][0];
		sum -= 구사과의방[공기청정기[1]+1][0];
		
		for (int i = 공기청정기[0]-1; i > 0; i--)
			구사과의방[i][0] = 구사과의방[i-1][0];
		for (int i = 1; i < C; i++)
			구사과의방[0][i-1] = 구사과의방[0][i];
		for (int i = 1; i <= 공기청정기[0]; i++)
			구사과의방[i-1][C-1] = 구사과의방[i][C-1];
		for (int i = C-1; i > 0; i--)
			구사과의방[공기청정기[0]][i] = 구사과의방[공기청정기[0]][i-1];
		
		for (int i = 공기청정기[1]+1; i < R-1; i++)
			구사과의방[i][0] = 구사과의방[i+1][0];
		for (int i = 1; i < C; i++)
			구사과의방[R-1][i-1] = 구사과의방[R-1][i];
		for (int i = R-1; i > 공기청정기[1]; i--)
			구사과의방[i][C-1] = 구사과의방[i-1][C-1];
		for (int i = C-1; i > 0; i--)
			구사과의방[공기청정기[1]][i] = 구사과의방[공기청정기[1]][i-1];
		
		구사과의방[공기청정기[0]][1] = 0;
		구사과의방[공기청정기[1]][1] = 0;
	}
}