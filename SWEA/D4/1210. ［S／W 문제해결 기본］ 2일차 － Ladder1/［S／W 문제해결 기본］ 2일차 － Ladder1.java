import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int a = 0; a < 10; a++) {
			int[][] arr = new int[100][100];
			int tc = sc.nextInt();
			int num2 = -1;
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					arr[j][k] = sc.nextInt();
					if (arr[j][k] == 2) {
						num2 = k;
					}
				}
			}

			boolean l = true;
			boolean r = true;
			for (int i = 99; i > 0; i--) {
				if (l && num2 > 0 && arr[i][num2-1] == 1) {
					num2 = num2-1;
					if (arr[i-1][num2] != 1) 
						i++;
					else {
						r= true;
						l= true;
						continue;
					}
					r =false;
					continue;
				}
				if (r && num2 < 99 && arr[i][num2+1] == 1) {
					num2 = num2+1;
					if (arr[i-1][num2] != 1) 
						i++;
					else {
						r= true;
						l= true;
						continue;
					}
					l = false;
					continue;
				}
			}
			System.out.println("#" + tc +" " + num2);
		}
	}
}