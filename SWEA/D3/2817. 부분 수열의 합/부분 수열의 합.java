import java.util.Scanner;

public class Solution {
	public static int N;
	public static int K;
	public static int C;
	public static int count;
	public static int[] number;
	public static boolean[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			number = new int[N];
			sel = new boolean[N];
			for (int i = 0; i < N; i++)
				number[i] = sc.nextInt();

			powerset(0);
			System.out.println("#" + tc + " " + count);
			count = 0; // 하나의 테스트케이스가 끝날때마다 초기화.
		}
		sc.close();
	}

	public static void powerset(int idx) {

		// 기저파트
		if (idx == N) {
			for (int i = 0; i < N; i++) {
				if (sel[i])
					C += number[i]; // true인 곳만 더해주기.
			}
			if (C == K)
				count++; // 더한것이 K와 같으면 카운트.
			C = 0; // 한줄 검사가 끝났으니 다시 초기화.
			return;
		}

		// 재귀파트
		// 이진트리처럼 두갈래로 나눠진다고 생각하면 편함!
		sel[idx] = true;
		powerset(idx + 1);

		// 위코드의 기저파트에서 리턴되면 아래의 코드가 실행됨.
		sel[idx] = false;
		powerset(idx + 1);
	}
}