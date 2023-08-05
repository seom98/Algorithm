import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			if(N % 2 == 0) {
				for (int j = 0; j < N/2; j++) {
					System.out.print("* ");
				}
				System.out.println();
				for (int j = 0; j < N/2; j++) {
					System.out.print(" *");
				}
				System.out.println();
			}
			else {
				for (int j = 0; j < N/2+1; j++) {
					System.out.print("* ");
				}
				System.out.println();
				for (int j = 0; j < N/2; j++) {
					System.out.print(" *");
				}
				System.out.println();
			}
		}
		
		sc.close();
	}
}
