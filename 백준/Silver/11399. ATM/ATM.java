import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] time = new int[N];
		for (int i = 0; i < N; i++) {
			time[i] = sc.nextInt();
		}
		Arrays.sort(time);
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = N-i; j > 0; j--) {
				count += time[i];
			}
		}
		System.out.println(count);
	}
}