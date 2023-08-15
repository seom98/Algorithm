import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] potion = new int[N];
		for (int i = 0; i < N; i++) {
			potion[i] = sc.nextInt();
		}

		int i = 0;
		int j = N-1;
		int min = potion[i] + potion[j];
		while (i != j) {
			if (Math.abs(potion[i + 1] + potion[j]) > Math.abs(potion[i] + potion[j - 1])) {
				if (i != j-1 && Math.abs(potion[i] + potion[j - 1]) < Math.abs(min)) {
					min = potion[i] + potion[j - 1];
				}
				j--;
			}
			else {
				if (i + 1 != j && Math.abs(potion[i + 1] + potion[j]) < Math.abs(min)) {
					min = potion[i + 1] + potion[j];
				}
				i++;
			}
			
			
		}
		System.out.println(min);
	}
}

