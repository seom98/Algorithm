import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int total = sc.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i< num; i++ ) {
			arr[i] =sc.nextInt();
		}
		    	 
	    int ans = 0;
	    for (int i = 0; i < num-2; i++) {
	        for (int j = i+1; j < num-1; j++) {
	            for (int k = j+1; k < num; k++) {
	                if (arr[i]+arr[j]+arr[k] <= total && ans < arr[i]+arr[j]+arr[k]) {
	                    ans = arr[i]+arr[j]+arr[k];
	                }
	            }
	        }
	    }
		System.out.println(ans);

		    	
	}
}
