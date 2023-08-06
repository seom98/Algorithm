import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = -100;
		int[] nanjang = new int[9];
		for (int i = 0; i < 9; i++) {
			int nan = sc.nextInt();
			nanjang[i] = nan;
			N += nan;
			
		}
		
		loof : for (int i = 0; i < 8; i++) {
			for (int j = 1; j < 9; j++) {
				if(i != j) {
					if (nanjang[i] + nanjang[j] == N) {
						nanjang[i] = 100;
						nanjang[j] = 100;
						break loof;
					}
				}
			}
		}
		
		Arrays.sort(nanjang);
		for (int i = 0; i < 7; i++) {
			sb.append(nanjang[i]).append('\n');
		}
		System.out.println(sb);
		sc.close();
	}
}