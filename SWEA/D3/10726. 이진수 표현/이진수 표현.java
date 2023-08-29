import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //테스트케이스의 개수.
         
        for (int tc = 1; tc<=t; tc++) {
        	
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	
        	if (M % (1 << N) == (1 << N) -1)
        		System.out.println("#" + tc + " " + "ON"); //출력 
        	else
        		System.out.println("#" + tc + " " + "OFF"); //출력 
        	
        }
        sc.close();
	}
}