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
		int min = Math.abs(potion[i] + potion[j]);
		int min1 = i;
		int min2 = j;
		while (i != j) {
			if (Math.abs(potion[i + 1] + potion[j]) > Math.abs(potion[i] + potion[j - 1])) {
				if (i != j-1 && Math.abs(potion[i] + potion[j - 1]) < min) {
					min = Math.abs(potion[i] + potion[j - 1]);
					min1 = i;
					min2 = j - 1;
				}
				j--;
			}
			else {
				if (i + 1 != j && Math.abs(potion[i + 1] + potion[j]) < min) {
					min = Math.abs(potion[i + 1] + potion[j]);
					min1 = i + 1;
					min2 = j;
				}
				i++;
			}
			
			
		}
		System.out.println(potion[min1] + " " + potion[min2]);
	}
}

