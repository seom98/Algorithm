import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			int tcnum = sc.nextInt();
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			for (int i = 0; i < 100; i++) {
				int hubo = 0;
				for (int j = 0; j < 100; j++) {
					hubo += arr[i][j];
				}
				if (max < hubo) {
					max = hubo;
				}
			}
			
			for (int i = 0; i < 100; i++) {
				int hubo = 0;
				for (int j = 0; j < 100; j++) {
					hubo += arr[j][i];
				}
				if (max < hubo) {
					max = hubo;
				}
			}
			int hubo1 = 0;
			for (int i = 0; i < 100; i++) {
				hubo1 += arr[i][i];
				if (max < hubo1) {
					max = hubo1;
				}
			}
			int hubo2 = 0;
			for (int i = 0; i < 100; i++) {
				hubo2 += arr[i][99-i];
				if (max < hubo2) {
					max = hubo2;
				}
			}
			

			System.out.println("#" + tcnum + " " + max);
		}
	}
}