import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //테스트케이스의 개수.
         
        for (int tc = 1; tc<=t; tc++) {
        	
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	
        	int x = 0;
        	String s = null;
        	
        	String[] sarr = new String[N]; //문자를 한줄씩 받아줌.
        	for (int i = 0; i < N; i++) {				
        		sarr[i] = sc.next();
			}
        	
        	for (int i = 0; i < N; i++) {				
        		for (int j = M-1; j >=0; j--) {
        			if (sarr[i].charAt(j) == '1') { //처음으로 나오는 1.
        				x = j-55; //암호코드의 시작인 부분.
        				s = sarr[i]; //암호코드.
        				break;
        			}
        		}
			}
        	int[] ans = new int[8]; //암호코드를 숫자로 바꿔서 넣어줄 배열.
        	for (int i = 0; i < 8; i++) {
        		String num = s.substring(x + i*7, x+7 + i*7); 
        		switch (num) {
				case "0001101":
					ans[i] = 0;
					break;
				case "0011001":
					ans[i] = 1;
					break;
				case "0010011":
					ans[i] = 2;
					break;
				case "0111101":
					ans[i] = 3;
					break;
				case "0100011":
					ans[i] = 4;
					break;
				case "0110001":
					ans[i] = 5;
					break;
				case "0101111":
					ans[i] = 6;
					break;
				case "0111011":
					ans[i] = 7;
					break;
				case "0110111":
					ans[i] = 8;
					break;
				case "0001011":
					ans[i] = 9;
					break;
				}
        	}
        	int count = 0;
        	for (int i =0; i < 8; i++) {
        		if (i % 2 == 0) {
        			count += ans[i]*3; //짝수번째만 *3을 함.
        		} else
        			count += ans[i]; //홀수번째는 그냥 +.
        	}
        	
        	int c = 0;
        	if (count % 10 == 0) { //올바른 암호코드라면 숫자의 합.
        		for (int i =0; i < 8; i++) {
            		c += ans[i];
        		} 
        	}
        	
        	System.out.println("#" + tc + " " + c); //출력 
        	
        }
        sc.close();
	}
}