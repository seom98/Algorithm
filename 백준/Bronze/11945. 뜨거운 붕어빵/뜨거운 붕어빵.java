import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] arr = new char[N][M];
		char[][] arr2 = new char[N][M];
		if (N != 0 && M != 0) {
			for (int i = 0; i < N; i++)
				arr[i] = sc.next().toCharArray();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr2[i][j] = arr[i][M - 1 - j];
					sb.append(arr2[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}
	}
}