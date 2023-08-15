import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		long[] pado = new long[101];
		pado[1] = 1;
		pado[2] = 1;
		pado[3] = 1;
		pado[4] = 2;
		pado[5] = 2;
		for (int j = 6; j <= 100; j++) {
			pado[j] = pado[j-1] + pado[j-5];
		}
		for (int i = 0; i < tc; i++) {
			int N = sc.nextInt();
			System.out.println(pado[N]);
		}
    }
}

