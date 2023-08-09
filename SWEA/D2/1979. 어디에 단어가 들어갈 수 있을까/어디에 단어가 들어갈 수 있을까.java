import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			int count = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					int cnt = 0;
					for (int a = 0; a < N; a++) {
						if (k + a < N && arr[j][k + a] == 1)
							cnt++;
						else
							break;
					}
					k += cnt;
					if (cnt == M) {
						count++;
					}
				}
			}
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					int cnt = 0;
					for (int a = 0; a < N; a++) {
						if (k + a < N && arr[k + a][j] == 1)
							cnt++;
						else
							break;
					}
					k += cnt;
					if (cnt == M) {
						count++;
					}
				}
			}

			System.out.println("#" + (i + 1) + " " + count);
		}
	}
}