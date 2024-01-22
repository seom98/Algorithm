import java.util.Scanner;

public class Main {
	static int[][] dp = new int[30][30];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt() - 1;
		int M = sc.nextInt() - 1;
		System.out.print(combination(N, M));
		sc.close();
	}
	static int combination(int n, int m) {
		if (dp[n][m] > 0)
			return dp[n][m];
		if (n == m || m == 0)
			return dp[n][m] = 1;
		return dp[n][m] = combination(n - 1, m - 1) + combination(n - 1, m);
	}
}