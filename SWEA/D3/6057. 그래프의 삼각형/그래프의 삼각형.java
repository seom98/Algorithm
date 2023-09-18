import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] arr = new int[N][N];
			for (int i = 0; i < M; i++) {
				int A = sc.nextInt() - 1;
				int B = sc.nextInt() - 1;
				arr[A][B] = 1;
				arr[B][A] = 1;
			}

			int count = 0;
			for (int i = 0; i < N-2; i++) {
				for (int j = i + 1; j < N-1; j++) {
					for (int k = j + 1; k < N; k++) {
						if (arr[i][j] == 1 && arr[j][k] == 1 && arr[k][i] == 1)
							count++;
					}
				}
			}
			System.out.println("#" + t + " " + count);
		}
		sc.close();
	}
}