import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 1 1 2 3 5 8 13 21 34 55
		int[] arr = new int[1001];
		
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i < 1001; i++) {
			arr[i] = (arr[i-2] + arr[i-1]) % 10007;
		}
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(arr[N]);
		sc.close();
	}
}