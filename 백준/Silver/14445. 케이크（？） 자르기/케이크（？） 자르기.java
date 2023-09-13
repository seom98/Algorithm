import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		if (N == 1) {
			System.out.println(0);
		} else if (N % 2 == 0) {
			System.out.println(N/2);
		} else {
			System.out.println(N/2 + 1);
		}
	}
}