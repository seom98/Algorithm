import java.util.Scanner;

public class Main {

	static int sum123[] = new int[11];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sum123[1] = 1;
		sum123[2] = 2;
		sum123[3] = 4;

		for (int j = 4; j <= 10; j++) {
			sum123[j] = sum123[j - 1] + sum123[j - 2] + sum123[j - 3];
		}

		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			System.out.println(sum123[n]);
		}
		sc.close();
	}
}