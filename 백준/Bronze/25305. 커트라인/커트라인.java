import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int[] carr = new int[10001];
        int[] aarr = new int[N];
        
        for (int i = 0; i<N; i++) {
        	arr[i] = sc.nextInt();
        	carr[arr[i]]++;
        }
        
        for (int i = 1; i < 10001; i++) {
        	carr[i] += carr[i-1];
        }
        
        for (int i = 0; i < N; i++) {
			aarr[--carr[arr[i]]] = arr[i];
        }
        
        
        System.out.println(aarr[N-M]);
    }
}
