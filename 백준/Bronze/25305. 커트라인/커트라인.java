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
        for (int i = 0; i < M; i++) {
        	for (int j = 0; j<N-i-1; j++) {
        		int temp = 0;
        		if (arr[j] > arr[j+1]) {
        			temp = arr[j];
        			arr[j] = arr[j+1];
        			arr[j+1] = temp;
        		}
        	}
        }
        System.out.println(arr[arr.length-M]);
    }
}
