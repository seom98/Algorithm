import java.util.Scanner;

public class Main {
	static String[][] arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		arr = new String[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = "*";
			}
		}

		star(N, 0, 0);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
		sc.close();

	}

	static void star(int N, int a, int b) {
		
		if (N == 1) {
			return;
		}

		for (int i = a; i < a+N; i++) {
			for (int j = b; j < b+N; j++) {
				if ((i/(N/3))%3 == 1 && (j/(N/3))%3 == 1) {
					arr[i][j] = " "; 
				}
			}
		}
		
		int n = N/3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				star(n, a+i*n, b+j*n);
			}
		}
	}
}