import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String SLL = sc.next();
		int count = 0;
		for(int i = 0; i < num;i++) {
			if (SLL.charAt(i) == 'L')
				count++;
		}
		if (count == 0)
			count+=2;
		System.out.println(num+1-count/2);
		sc.close();
	}
}