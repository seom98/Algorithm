import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();

		for (int a = 0; a < N; a++) {
			int[][] arr = new int[4][2];
			int A = sc.nextInt();
			for (int i = 0; i < A; i++)
				arr[sc.nextInt()-1][0]++;
			int B = sc.nextInt();
			for (int i = 0; i < B; i++)
				arr[sc.nextInt()-1][1]++;
			
			int s = 2;
			if (arr[3][0] > arr[3][1]) {
				s = 0;
			} else if (arr[3][0] < arr[3][1]) {
				s = 1;
			} else {
				if (arr[2][0] > arr[2][1]) {
					s = 0;
				} else if (arr[2][0] < arr[2][1]) {
					s = 1;
				} else {
					if (arr[1][0] > arr[1][1]) {
						s = 0;
					} else if (arr[1][0] < arr[1][1]) {
						s = 1;
					} else {
						if (arr[0][0] > arr[0][1]) {
							s = 0;
						} else if (arr[0][0] < arr[0][1]) {
							s = 1;
						}
					}
				}
			}
			
				
			System.out.println(s == 0 ? "A" : s == 1 ? "B" : "D");
		}
		
		
		sc.close();
	}
}