import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] A = sc.next().toCharArray();
        char[] B = sc.next().toCharArray();
        int C = 16;

        String num = "";
        for (int i = 0; i < 8; i++) {
            num += A[i];
            num += B[i];
        }
        for (int i = 0; i < 14; i++) {
        	C--;
        	String newNum = "";
            for (int j = 0; j < C; j++) {
            	newNum += Integer.toString(((num.charAt(j)-'0') + (num.charAt(j+1)-'0')) % 10);
            	}
            num  = newNum;
            }
        System.out.print(num);
    }
}