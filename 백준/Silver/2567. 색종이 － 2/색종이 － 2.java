import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[102][102];
		
		int N = sc.nextInt();
		for (int a = 0; a < N; a++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					arr[i][j] = 1;
				}
			}	
		}
		
		int count = 0;
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				if (arr[i][j] == 0) {
					if (i-1 > -1 && arr[i-1][j] == 1)
						count++;
					if (j-1 > -1 && arr[i][j-1] == 1)
						count++;
					if (i+1 < 102 && arr[i+1][j] == 1)
						count++;
					if (j+1 < 102 && arr[i][j+1] == 1)
						count++;
				}
			}
		}
		System.out.println(count);
		sc.close();
	}
}