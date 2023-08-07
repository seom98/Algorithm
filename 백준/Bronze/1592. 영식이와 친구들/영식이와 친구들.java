import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        
        int[] arr = new int[N];
        arr[0]=1;
        
        
        int a = 1;
        int i = 0;
        int count = 0;
        while (!(a == M)) {
        	if (arr[i]%2 == 0) {
        		i = ((i-L+N) % N);
        		arr[i]++;
        		a = arr[i];
        		count++;
        	} else {
        		i = ((i+L) % N);
        		arr[i]++;
        		a = arr[i];
        		count++;
        	}
        }
        
        System.out.println(count);

        sc.close();
    }
}
