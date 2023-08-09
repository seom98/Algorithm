import java.util.Arrays;
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
				for (int k =0; k < N; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			int max = 0;
			for (int j = 0; j <= N-M; j++) {
				for (int k =0; k <= N-M; k++) {
					int m = 0;
					for (int a = 0; a < M; a++) {
						for (int b = 0; b < M; b++) {
							m += arr[j+a][k+b];
						}
					}
					if(max < m) {
						max = m;
					}
				}
			}

			System.out.println("#" + (i+1) +" " + max);
		}
	}
}