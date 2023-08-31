import java.util.Scanner;

public class Main {
	static int A;
	static int C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		int B = sc.nextInt();
		C = sc.nextInt();
		
		System.out.print(multiplication(B));
		sc.close();
	}

	static long multiplication(int B) {

		// 기저조건 
		if (B == 1) {
			return A % C;
		}

		// 재귀조건
		// 짝수일때
		
		long res = multiplication(B / 2) % C;
		
		if (B % 2 == 0) {
			return (res * res) % C;
		}
		// 홀수일때
		else {
			return ((res * res) % C) * A % C;
		}
	}
}