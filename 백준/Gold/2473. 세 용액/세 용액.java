import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		long[] potion = new long[N];

		for (int i = 0; i < N; i++) {
			potion[i] = sc.nextInt();
		}

		Arrays.sort(potion);

		long[] ans = new long[3];

		long min = Long.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			int l = i + 1;
			int r = N - 1;

			while (l < r) {
				long sum = potion[i] + potion[l] + potion[r];

				long abs = Math.abs(sum);

				if (abs < min) {
					min = abs;
					ans[0] = potion[i];
					ans[1] = potion[l];
					ans[2] = potion[r];
				}

				if (sum > 0)
					r--;
				else
					l++;
			}
		}
		System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
	}
}