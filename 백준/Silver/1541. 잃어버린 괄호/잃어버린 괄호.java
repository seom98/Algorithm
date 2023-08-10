import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		int ans = Integer.MAX_VALUE;
		String[] minus = sc.nextLine().split("-");
		
 
		for(int i = 0; i < minus.length; i++) {
			int sum = 0;
 
			
			String[] plus = minus[i].split("[+]");
			
			
			for(int j = 0; j < plus.length; j++) {
				sum += Integer.parseInt(plus[j]);
			}
			
			
			if (ans == Integer.MAX_VALUE) {
				ans = sum;
			} else {
				ans -= sum;
			}
		}
		System.out.println(ans);
	}
 
}