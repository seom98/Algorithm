import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] arr = new int[10];
        
        
        int num = 0;
        int index = 0;
        for (int i = 0; i < 10; i++) {
        	arr[i] = sc.nextInt();
        	if (num < 100) {
        		num += arr[i];
        		index = i;
        	}
        }
        
        if (index > 0) {
        	if (num - 100 > (100 - (num - arr[index]))) {
            	System.out.println(num - arr[index]);
            } else {
            	System.out.println(num);
            }
        } else {
        	System.out.println(num);
        }
        
        

        sc.close();
    }
}
