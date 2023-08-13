import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i<N; i++) {
        	arr[i] = sc.nextInt();
        }
        
        
        int count = M;
    	for (int j = N-1; j>0; j--) {
    		int max = j;
    		for (int k = 0; k < j; k++) {
    			if (arr[k] > arr[max]) {
    				max = k;
    			}
    		}
            int temp = 0;
            if (arr[max] > arr[j]) {
            	count--;
                temp = arr[j];
                arr[j] = arr[max];
                arr[max] = temp;
            }
            if (count == 0) {
            	for (int i = 0; i< N; i++) {
            		System.out.print(arr[i] + " ");
            	}
            	return;
            }
    	}
    	System.out.println(-1);
    	
    }
}