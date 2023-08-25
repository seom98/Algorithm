import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //테스트케이스의 개수.
         
        for (int tc = 1; tc<=t; tc++) {
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	char[][] arr = new char[N][M];
        	int[][] count = new int[N][3];
        	
        	for (int i = 0; i < N; i++) {
        		String wbr = sc.next();
        		for (int j = 0; j < M; j++) {
        			char c = wbr.charAt(j);
        			arr[i][j] = c;
        			if (c == 'W') {
        				count[i][0]++;
        			} else if (c == 'B') {
        				count[i][1]++;
        			} else if (c == 'R') {
        				count[i][2]++;
        			}
        		}
        	}
        	
        	int min = Integer.MAX_VALUE;
        	
        	for (int i = 1; i <= N-2; i++) { //b의 행개수.
        		for (int j = 1; j <= N-1-i; j++) { //b줄이 위치하는 행.
        			int cnt = 0;
        			for (int a = 0; a < j; a++) {
        				cnt += M - count[a][0];
        			}
        			for (int a = j; a < j+i; a++) {
        				cnt += M - count[a][1];
        			}
        			for (int a = j+i; a < N; a++) {
        				cnt += M - count[a][2];
        			}
        			if (min > cnt) {
        				min = cnt;
        			}
        		}
        	}
        	
        	
        	System.out.println("#" + tc + " " + min); //출력 
        }
        sc.close();

	}

}