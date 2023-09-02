import java.util.Scanner;
 
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int min = 0;
        while(true) {
            int x = N + min;
            int count = 0;
            
            while(x > 0) {
                if(x % 2 != 0)
                    count++;
                x /= 2;
            }
            if(count <= K)
                break;
            
            min++;
        }
        
        System.out.println(min);
        sc.close();
    }
}