import java.util.Scanner;

public class Solution {
	public static int N;
	public static int K;
	public static int max = Integer.MIN_VALUE;
	public static int[] point;
	public static int[] calorie;
	public static boolean[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			point = new int[N];
			calorie = new int[N];
			sel = new boolean[N];
			for (int i = 0; i < N; i++) {
				point[i] = sc.nextInt();
				calorie[i] = sc.nextInt();
				
			}

			powerset(0, 0, 0);
			System.out.println("#" + tc + " " + max);
			max = Integer.MIN_VALUE; // 하나의 테스트케이스가 끝날때마다 초기화.
		}
		sc.close();
	}

	public static void powerset(int idx, int p, int c) {

		// 기저파트
		if (idx == N) {
			if (c < K) {
				if (max < p) {
					max = p;
				}
			}
			p = 0;
			c = 0;
			return;
		}

		// 재귀파트
		// 이진트리처럼 두갈래로 나눠진다고 생각하면 편함!
		sel[idx] = true;
		powerset(idx + 1, p+point[idx], c+calorie[idx]);

		// 위코드의 기저파트에서 리턴되면 아래의 코드가 실행됨.
		sel[idx] = false;
		powerset(idx + 1, p, c);
	}
}