import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N;
	static char[][] arr;
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };
	static int danji = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.next().toCharArray();
		}
		int count = 0;
		List<Integer> danjis = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (arr[i][j] == '1') {
					count++;
					DFS(i, j);
					danjis.add(danji);
					danji = 0;
				}
			}
		}
		Collections.sort(danjis);
		System.out.println(count);
		for (int ele : danjis) {
			System.out.println(ele);
		}
		sc.close();
	}
	static void DFS(int i, int j) {
		danji++;
		arr[i][j] = '2';
		
		for (int d = 0; d < 4; d++) {
			int x = i + drow[d];
			int y = j + dcol[d];

			if (x >= 0 && x < N && y >= 0 && y < N && arr[x][y] == '1')
				DFS(x, y);
		}
	}
}