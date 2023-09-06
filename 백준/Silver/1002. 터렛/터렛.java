import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int[][] arr = new int[2][3];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 3; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			double A = Math.sqrt((arr[0][0]-arr[1][0])*(arr[0][0]-arr[1][0]) + (arr[0][1]-arr[1][1])*(arr[0][1]-arr[1][1]));
			double B1 = arr[0][2] < arr[1][2] ? arr[1][2] : arr[0][2];
			double B2 = arr[0][2] < arr[1][2] ? arr[0][2] : arr[1][2];
			
			int ans = 0;
			if(equal(arr)) ans = -1;
			else {
				if (B1+B2<=A) ans = B1+B2==A ? 1 : 0;
				else {
					if (B1==A+B2) ans = 1;
					else if (B1<A+B2) ans = 2;
					else if (B1>A+B2) ans = 0;
				}
			}
			System.out.println(ans);
		}
		sc.close();

	}
	static boolean equal(int[][] arr) {
		for (int i = 0; i < 3; i++) {
			if (arr[0][i]!=arr[1][i]) return false;
		}
		return true;
	}

}