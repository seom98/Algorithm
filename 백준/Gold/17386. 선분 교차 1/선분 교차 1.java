import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x1 = sc.nextInt(), y1 = sc.nextInt();
		long x2 = sc.nextInt(), y2 = sc.nextInt();
		long x3 = sc.nextInt(), y3 = sc.nextInt();
		long x4 = sc.nextInt(), y4 = sc.nextInt();
		
		long A = x1*y2 + x2*y3 + x3*y1 - x2*y1 - x3*y2 - x1*y3;
		long B = x1*y2 + x2*y4 + x4*y1 - x2*y1 - x4*y2 - x1*y4;
		long C = x3*y4 + x4*y1 + x1*y3 - x4*y3 - x1*y4 - x3*y1;
		long D = x3*y4 + x4*y2 + x2*y3 - x4*y3 - x2*y4 - x3*y2;
		
		A = A>0 ? 1 : -1; 
		B = B>0 ? 1 : -1; 
		C = C>0 ? 1 : -1; 
		D = D>0 ? 1 : -1; 

		System.out.println(A*B<0 && C*D<0 ? 1 : 0);
		sc.close();
	}
}