import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long M = sc.nextLong();
		long N = sc.nextLong();

		
		//꺾이는 횟수 구하기.
		long moseori = 0;
		if (M <= N) {
			moseori = (M - 1) * 2;
		} else {
			moseori = (N - 1) * 2 + 1;
		}

		//마지막 좌표구하기. 왼쪽위가 (0,0)이 아니라 (1,1)임.
		long x = 0, y = 0;
		if (M == N) {
			if (M % 2 == 1) {
				x = M / 2 + 1;
				y = N / 2 + 1;
			} else {
				x = M / 2 + 1;
				y = N / 2;
			}
		} else if (M > N) {
			if (N % 2 == 0) {
				x = N / 2 + 1;
				y = N / 2;
			} else {
				x = N / 2 + 1 + (M - N);
				y = N / 2 + 1;
			}
		} else {
			if (M % 2 == 0) {
				x = M / 2 + 1;
				y = M / 2;
			} else {
				x = M / 2 + 1;
				y = M / 2 + 1 + (N - M);
			}
		}
		System.out.println(moseori + "\n" + x + " " + y);
	}
}