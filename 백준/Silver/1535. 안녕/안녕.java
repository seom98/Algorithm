import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt()+1;
		//체력 
		int[] arr1 = new int[N];
		for (int i = 1; i < N; i++)
			arr1[i] = sc.nextInt();
		//기쁨 
		int[] arr2 = new int[N];
		for (int i = 1; i < N; i++)
			arr2[i] = sc.nextInt();
		//dp
		int[][] dp = new int[N][100];

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < 100; j++) {
				//아직 체력을 깎아도 될때의 최댓값
				if (arr1[i] <= j)
					dp[i][j] = Math.max(dp[i-1][j-arr1[i]] + arr2[i], dp[i-1][j]);
				// 아닐 때
				else dp[i][j] = dp[i-1][j];
			}
		}
		//가장 끝에 오는 것이 답
		System.out.println(dp[N-1][99]);
	}
}