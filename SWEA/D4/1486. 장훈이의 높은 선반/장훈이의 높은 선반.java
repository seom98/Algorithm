import java.util.Scanner;

public class Solution {
	static int N, B, ans;
	static int[] H;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			H = new int[N];
			B = sc.nextInt();
			for (int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
			}
			ans = 987654321;

			for (int i = 0; i < (1 << N); i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) != 0)
						sum += H[j];
				}
				if (sum >= B && sum < ans)
					ans = sum;
			}
			System.out.println("#" + t + " " + (ans - B));
		}
		sc.close();
	}
}