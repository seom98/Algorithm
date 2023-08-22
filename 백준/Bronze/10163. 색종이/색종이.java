import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[1001][1001];

		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			for (int x = a; x < a+c; x++) {
				for (int y = b; y < b + d; y++) {
					arr[x][y] = i+1;
				}
			}

		}
		int[] cnt = new int[N+1];
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				cnt[arr[i][j]]++;
			}
		}
		for (int i = 1; i < N+1; i++) {
			System.out.println(cnt[i]);
		}
	}
}