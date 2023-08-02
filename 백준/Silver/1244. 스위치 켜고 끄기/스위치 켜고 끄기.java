import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int person = sc.nextInt();
		
		for (int i = 0; i < person; i++) {
			int gender = sc.nextInt();
			int number = sc.nextInt();
			
			if (gender == 1) {
				int j = 1;
				while (j*number <= N) {
					arr[j*number] = (arr[j*number]+1)%2;
					j++;
				}
			} else {
				int j = 1;
				arr[number] = (arr[number]+1)%2;
				while (number-j > 0 && number+j <= N && arr[number-j] == arr[number+j]) {
					arr[number-j] = (arr[number-j]+1)%2;
					arr[number+j] = (arr[number+j]+1)%2;
					j++;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(arr[i] + " ");
			if(i % 20 == 0) {
				System.out.println();
			}
		}
		
		sc.close();
	}
}
