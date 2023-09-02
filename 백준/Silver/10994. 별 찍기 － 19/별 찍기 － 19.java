import java.util.Scanner;

public class Main {
	
	static int X;
	static String[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		X = N*4 -3;
		arr = new String[N*4-3][N*4-3];
		star(N*4-3, 0);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N*4-3; i++) {
			for (int j = 0; j < N*4-3; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		sc.close();

	}
	
	static void star(int n, int a) {
		
		if (n == 1) {
			arr[a][a] = "*";
			return;
		}
		
		for (int i = a; i < X-a; i++) {
			for (int j = a; j < X-a; j++) {
				if (i == a || i == X-a-1 || j == a || j == X-a-1) {
					arr[i][j] = "*";
				} else {
					arr[i][j] = " ";
				}
			}
		}
		star(n-4, a+2);
	}

}