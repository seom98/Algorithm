import java.util.Scanner;

public class Main {
	
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int z = (int) Math.pow(2,N);
		Z(z, r, c);
		System.out.println(count);
	}
	static void Z(int z, int r, int c) {
		
		if(z == 1) {
			return; 
		}
		
		if (r < z/2 && c < z/2) {
			count += 0;
			Z(z/2, r, c);
		} else if (r < z/2 && c >= z/2) {
			count += z*z/4;
			Z(z/2, r, c-z/2);
		} else if (r >= z/2 && c < z/2) {
			count += z*z/4*2;
			Z(z/2, r-z/2, c);
		} else if (r >= z/2 && c >= z/2) {
			count += z*z/4*3;
			Z(z/2, r-z/2, c-z/2);
		}
	}

}