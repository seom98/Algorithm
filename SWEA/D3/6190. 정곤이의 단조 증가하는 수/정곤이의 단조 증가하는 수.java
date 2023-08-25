import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //테스트케이스의 개수.
         
        for (int tc = 1; tc<=t; tc++) {
        	int N = sc.nextInt();
        	int[] arr = new int[N];
        	
        	for (int i = 0; i < N; i++) {
        		arr[i] = sc.nextInt();
        	}
        	
        	int max = -1; //곱한값의 최댓값. 
        	for (int i = 0; i < N-1; i++) {
        		for (int k = i+1; k < N; k++) {
        			int num_multiply = arr[i]*arr[k]; //두수를 곱한값. 
        			String multiply = String.valueOf(num_multiply); //두수를 곱한값을 스트링으로 변경.
        			boolean chack = true; //단조증가인지 확인.
        			for (int j = 0; j < multiply.length()-1; j++) { //스트링의 길이-1만큼 포문.
        				if (multiply.length() == 1) { //길이가 1이면 무조건 단조증가이므로 패스;
        					break;
        				} else if (multiply.charAt(j) > multiply.charAt(j+1)) //단조증가가 아니라면 체크를 false로.
        					chack = false;
        			}
        			if (chack && max < num_multiply) { //단조증가이면서 최댓값보다 큰값이 나왔을때. 
        				max = num_multiply; //최댓값 변경.
        			}
        		}
        	}
        	System.out.println("#" + tc + " " + max); //출력 
        }
        sc.close();
	}
}