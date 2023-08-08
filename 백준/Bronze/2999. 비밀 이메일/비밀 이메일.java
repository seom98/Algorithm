import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int len = str.length();
		
		
		int a = 0;
		int b = 0;
		for (int i = 1; i <= Math.sqrt(len); i++) {
			if (len % i == 0) {
				a = i;
				b = len / i;
			}
		}
		
		char[][] arr = new char[b][a];
		int k=0;
		for(int i = 0; i < b; i++) {
			for (int j = 0; j < a; j++) {
				arr[i][j] = str.charAt(k++);
			}
		}
		
		
		for(int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				System.out.print(arr[j][i]);
			}
		}
	}

}
