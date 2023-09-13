import java.util.Scanner;

public class Main {
	
	static int N;
	static char[][] yes;
	static char[][] no;
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		no = new char[N][N];
		yes = new char[N][N];
		for(int i = 0; i < N; i++) {
			String s = sc.next();
			no[i] = s.toCharArray();
			yes[i] = s.toCharArray();
		}
		int noCount = 0;
		int yesCount = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (no[i][j] != '1') {
					noCount++;
					noDFS(i, j, no[i][j]);
				}
				if (yes[i][j] != '1') {
					yesCount++;
					yesDFS(i, j, yes[i][j]);
				}
			}
		}
		System.out.println(noCount + " " + yesCount);
		sc.close();
	}
	static void noDFS(int i, int j, char c) {
		no[i][j] = '1';
		
		for (int d = 0; d < 4; d++) {
			int x = i + drow[d];
			int y = j + dcol[d];
			
			if (x >= 0 && x < N && y >= 0 && y < N && no[x][y] == c)
				noDFS(x, y, c);
		}
	}
	static void yesDFS(int i, int j, char c) {
		yes[i][j] = '1';
		
		for (int d = 0; d < 4; d++) {
			int x = i + drow[d];
			int y = j + dcol[d];

			if (x >= 0 && x < N && y >= 0 && y < N) {
				if (c == 'R' && yes[x][y] == 'G' || c == 'G' && yes[x][y] == 'R')
					yesDFS(x, y, yes[x][y]);
				else if (yes[x][y] == c)
					yesDFS(x, y, c);
			}
		}
	}
}