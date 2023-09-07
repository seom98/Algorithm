import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int x1 = sc.nextInt(), y1 = sc.nextInt();
			int x2 = sc.nextInt(), y2 = sc.nextInt();
			int N = sc.nextInt();
			int C = 0;
			for (int i = 0; i < N; i++) {
				int a = sc.nextInt(), b = sc.nextInt(), r = sc.nextInt(), P = 0;
				if((x1-a)*(x1-a) + (y1-b)*(y1-b) < r*r) P++;
				if((x2-a)*(x2-a) + (y2-b)*(y2-b) < r*r) P++;
				if (P == 1) C++;
			}
			System.out.println(C);
		}
		sc.close();
	}
}