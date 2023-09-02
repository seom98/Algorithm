import java.util.Scanner;

public class Main {
	
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N+2];
		arr[0] = 0;
		arr[1] = 1;
		babba(N);
		System.out.println(arr[N-1] + " " + arr[N]);
	}
	
	
	static void babba(int N) {
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
	}
}