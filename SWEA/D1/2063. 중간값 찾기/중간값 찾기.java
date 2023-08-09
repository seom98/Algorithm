import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args)  throws Exception{


        Scanner sc = new Scanner(System.in);
        int Num = sc.nextInt();
        int[] arr = new int[Num];
        for (int i = 0; i < Num; i++) {
        	arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        
        System.out.println(arr[Num/2]);
        
    }
}