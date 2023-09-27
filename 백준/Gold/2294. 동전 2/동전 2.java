import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int money = sc.nextInt();
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int[] dp = new int[money+1];
		
		for (int i = 1; i <= money; i++) {
			dp[i] = Integer.MAX_VALUE-1;

			for(int j = 0; j < N; j++) {
				if (i >= arr[j])
					dp[i] = Math.min(dp[i-arr[j]]+1, dp[i]);
			}

		}
		if (dp[money] == Integer.MAX_VALUE-1)
			System.out.println(-1);
		else
			System.out.println(dp[money]);
		sc.close();
	}

}