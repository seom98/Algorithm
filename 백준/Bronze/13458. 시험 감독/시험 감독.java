import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		long count = N;
		for (int i = 0; i < N; i++) {
			A[i] -= B;
			if (A[i] > 0) {				
				if(A[i]%C == 0) count--;
				A[i] /= C;
				count += A[i]+1;
			}
		}
		System.out.println(count);
		sc.close();
	}
}