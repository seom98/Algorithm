import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[2][6];
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		for (int a = 0; a < N; a++) {
			int x = sc.nextInt();
			int y = sc.nextInt()-1;
			arr[x][y]++;	
		}
		
		int count = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				if (arr[i][j] != 0)
					count += (arr[i][j] - 1) / M + 1;
			}
		}
		
		System.out.println(count);
		sc.close();
	}
}