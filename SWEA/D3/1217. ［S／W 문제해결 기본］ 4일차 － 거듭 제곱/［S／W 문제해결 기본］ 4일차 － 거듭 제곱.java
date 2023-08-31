import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println("#" + tc + " " + pow(N, M));
		}
		sc.close();
	}

	public static long pow(int C, int N) {
		//기저조건 
		if (N == 1) return C;
		
		//재귀조건 
		//짝수일때
		if (N % 2 == 0) {
			long res = pow(C, N/2);
			return res * res;
		} 
		//홀수일때 
		else {
			long res = pow(C, (N-1)/2);
			return res * res* C;
		}
		
	}
}