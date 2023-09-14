import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			arr[i] = sc.nextInt();
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (M / arr[i] > 0) {
				count += M / arr[i];
				M = M % arr[i];
			}
		}
		System.out.println(count);
	}
}
