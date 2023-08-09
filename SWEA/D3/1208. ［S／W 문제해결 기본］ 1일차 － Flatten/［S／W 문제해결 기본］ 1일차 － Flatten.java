import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args)  throws Exception{
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
        	int N = sc.nextInt();
        	int[] arr = new int[100];
        	for (int j = 0 ; j < 100; j++) {
        		arr[j] = sc.nextInt();
        	}
        	for (int j = 0; j < N; j++) {
        		arr[0]++;
        		arr[99]--;
        		if (arr[0] == arr[99]) {
        			break;
        		}
        		Arrays.sort(arr);
        	}
        	System.out.println("#" + i + " " + (arr[99]-arr[0]));
        }   
    }
}