import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 0 1 1 2 3 5 8
		int[] arr = new int[41];
		
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < 41; i++) {
			arr[i] = arr[i-2] + arr[i-1];
		}
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			if (a == 0) System.out.println("1 0");
			else System.out.println(arr[a-1] + " " + arr[a]);
		}
		sc.close();
	}
}