import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long[] x = new long[N + 1];
		long[] y = new long[N + 1];
		long sum1 = 0, sum2 = 0;

		for (int i = 0; i < N; i++) {
			x[i] = sc.nextLong();
			y[i] = sc.nextLong();
		}

		x[N] = x[0];
		y[N] = y[0];

		for (int i = 0; i < N; i++) {
			sum1 += x[i] * y[i + 1];
			sum2 += x[i + 1] * y[i];
		}
		System.out.printf("%.1f", (Math.abs(sum1 - sum2) / 2.0));
		sc.close();
	}
}