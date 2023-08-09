import java.util.Scanner;

public class Solution {

    public static void main(String[] args)  throws Exception{


        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
        	int[] arr = new int[101];
        	int a = sc.nextInt();
        	
        	for (int j = 0; j< 1000; j++) {
        		arr[sc.nextInt()]++;
        	}
        	int max = 0;
        	int maxIndex = 0;
        	for (int j = 0; j <= 100; j++) {
        		if (max <= arr[j]) {
        			max = arr[j];
        			maxIndex = j;
        		}
        	}
        	System.out.println("#"+ a + " " + maxIndex);
        }   
    }
}