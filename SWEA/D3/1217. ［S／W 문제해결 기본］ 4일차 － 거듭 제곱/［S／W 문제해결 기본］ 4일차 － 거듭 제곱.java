import java.util.Scanner;

public class Solution {
	public static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
            sc.nextInt();
			N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println("#" + tc + " " + power(M));
		}
		sc.close();
	}

	public static int power(int M) {
		if (M == 1) return N;
		return N * power(M - 1);
	}

}