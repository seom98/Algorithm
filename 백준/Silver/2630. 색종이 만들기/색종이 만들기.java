import java.util.Scanner;

public class Main {

	static int white = 0;
	static int blue = 0;
	static int[][] arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		paper(0, 0, N);
		System.out.print(white + "\n" + blue);
		sc.close();

	}

	static void paper(int a, int b, int N) {

		if (check(a, b, N)) {
			if (arr[a][b] == 0) white++;
			else blue++;
			return;
		}

		int half = N / 2;

		paper(a, b, half);
		paper(a, b + half, half);
		paper(a + half, b, half);
		paper(a + half, b + half, half);
	}

	static boolean check(int a, int b, int N) {
		int color = arr[a][b];

		for (int i = a; i < a + N; i++) {
			for (int j = b; j < b + N; j++) {
				if (arr[i][j] != color)
					return false;
			}
		}
		return true;
	}
}