import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] a = new int[N][2];
		for (int i = 0; i < N; i++) {
			a[i][0] = sc.nextInt();
			a[i][1] = sc.nextInt();
		}
		int max = 0;
		for (int i = 0; i < N-2; i++) {
			for(int j = i+1; j < N-1; j++) {
				for(int k = j+1; k < N; k++) {
					int x = Math.abs((a[i][0]*a[j][1] + a[j][0]*a[k][1] + a[k][0]*a[i][1]) - (a[j][0]*a[i][1] + a[k][0]*a[j][1] + a[i][0]*a[k][1]));
					if(max < x) max = x;
				}
			}
		}
		double ans = max/2.0;
		System.out.print(ans);
		sc.close();
	}
}