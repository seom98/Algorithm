import java.util.Scanner;

public class Main {

	static int[][] dp = new int[1001][1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();

		System.out.println(combination(M, N));

		sc.close();

	}

	static int combination(int n, int m) {
		if (dp[n][m] > 0)
			return dp[n][m];

		if (n == m || m == 0)
			return dp[n][m] = 1;

		return dp[n][m] = (combination(n - 1, m - 1) + combination(n - 1, m)) % 10007;
	}

}