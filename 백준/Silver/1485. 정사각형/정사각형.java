import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int[] x = new int[4];
			int[] y = new int[4];
			for (int i = 0; i < 4; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			long[] num = new long[6];
			
			num[0] = (x[0]-x[1])*(x[0]-x[1]) + (y[0]-y[1])*(y[0]-y[1]);
			num[1] = (x[1]-x[2])*(x[1]-x[2]) + (y[1]-y[2])*(y[1]-y[2]);
			num[2] = (x[2]-x[3])*(x[2]-x[3]) + (y[2]-y[3])*(y[2]-y[3]);
			num[3] = (x[3]-x[0])*(x[3]-x[0]) + (y[3]-y[0])*(y[3]-y[0]);
			num[4] = (x[3]-x[1])*(x[3]-x[1]) + (y[3]-y[1])*(y[3]-y[1]);
			num[5] = (x[0]-x[2])*(x[0]-x[2]) + (y[0]-y[2])*(y[0]-y[2]);
			
			Arrays.sort(num);
			
			if (num[0] == num[1] && num[1] == num[2] && num[2] == num[3] && num[3] != num[4] && num[4] == num[5])
				System.out.println(1);
			else
				System.out.println(0);
		}
		sc.close();

	}

}