import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[6][2];
		
		for (int i = 0; i < 6; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		for(int i = 0; i < 6; i++) {
			if (arr[(i+0) % 6][0]  == arr[(i+2) % 6][0] && arr[(i+1) % 6][0] == arr[(i+3) % 6][0]) {
				System.out.println(N * (arr[(i+4) % 6][1] * arr[(i+5) % 6][1] - arr[(i+1) % 6][1] * arr[(i+2) % 6][1]));
			}
		}
	}
}