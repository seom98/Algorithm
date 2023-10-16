import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int T = sc.nextInt();
    	for (int t = 0; t < T; t++) {
    		N -= sc.nextInt() * sc.nextInt();
    	}
    	if (N == 0) {
    		System.out.println("Yes");
    	} else System.out.println("No");
    	sc.close();
    }
}