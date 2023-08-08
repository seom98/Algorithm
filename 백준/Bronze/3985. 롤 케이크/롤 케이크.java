import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cake = new int[sc.nextInt()];
		int person = sc.nextInt();
		
		
		int max = 0;
		int index = 0;
		for (int i = 1; i <= person; i++) {
			int f = sc.nextInt();
			int l = sc.nextInt();
			if (max < l-f) {
				max = l-f;
				index = i;
			}
			for (int j = f; j <= l; j++) {
				if (cake[j-1] == 0) {
					cake[j-1] = i;					
				}
			}
		}
		
		int[] perr = new int[person];
		for (int i = 0; i < cake.length; i++) {
			for (int j = 0; j < person; j++) {
				if (cake[i] == j+1) {
					perr[j]++;
				}
			}
		}

		int M = 0;
		int Mindex = 0;
		for (int i =0; i< person; i++) {
			if(M < perr[i]) {
				M = perr[i];
				Mindex = i+1;
			}
		}
		System.out.println(index + "\n" + Mindex);
		
		
	}

}
