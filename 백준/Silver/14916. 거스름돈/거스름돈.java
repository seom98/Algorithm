import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    int count = 0; //2이 몇번 나왔나 세는거
	    while (true) {
	        if (N % 5 == 0) { //5로 나눠진다.
	            System.out.print(N / 5 + count);
	            break;
	        }
	        if (0 > N) { //수가 마이너스가 됐다.
	        	System.out.print(-1);
	            break;
	        } 
	        N -= 2; // 2을 빼줬으니 카운트 한번 해줌.
					count++;
	    }
		sc.close();
	}
}