import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        int[][] arr = new int[100][100];
        int count = 0;
        for (int i = 1; i <= num; i++) {
        	int square1 = sc.nextInt();
        	int square2 = sc.nextInt();
            for (int j = square1; j < square1+10; j++) {
                for (int k = square2; k < square2+10; k++) {
                    if (arr[j][k]==0) {
                        arr[j][k]++;
                    }
                }
            }
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);

        sc.close();
    }
}
