import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.print(a + b + c - Math.min(a, Math.min(b, c)) - Math.max(a, Math.max(b, c)));
		sc.close();
	}
}