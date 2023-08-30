import java.util.Scanner;

public class Main {
	public static int N;
	public static int K;
	public static int count;
	public static int[] number;
	public static boolean[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		number = new int[N];
		sel = new boolean[N];
		for (int i = 0; i < N; i++)
			number[i] = sc.nextInt();

		powerset(0, 0);
		System.out.println(count);

		sc.close();
	}

	public static void powerset(int idx, int C) {

		// 기저파트
		if (idx == N) {
			if (K == 0) {
				int x = 0;
				for (int i = 0; i < N; i++) {
					if(sel[i])
						x++;
				}
				if (x == 0) {
					return;
				} else {
					if (C == K)
						count++; // 더한것이 K와 같으면 카운트.
					C = 0; // 한줄 검사가 끝났으니 다시 초기화.
					return;
				}
			} else {
				if (C == K)
					count++; // 더한것이 K와 같으면 카운트.
				C = 0; // 한줄 검사가 끝났으니 다시 초기화.
				return;
			}
		}

		// 재귀파트
		// 이진트리처럼 두갈래로 나눠진다고 생각하면 편함!
		sel[idx] = false;
		powerset(idx + 1, C);

		// 위코드의 기저파트에서 리턴되면 아래의 코드가 실행됨.
		sel[idx] = true;
		powerset(idx + 1, C+number[idx]);
	}
}