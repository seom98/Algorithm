import java.util.Scanner;

public class Main {
    static int[] d1 = {-1, 1, -1, 1};
    static int[] d2 = {1, -1, 1, -1};
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[4][8];
        for (int i = 0; i<4; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < 8; j++)
                arr[i][j] = s.charAt(j) - '0';
        }
        
        int[][] set = new int[4][3];
        for (int i = 0; i < 4; i++) {
            set[i][0] = 6;
            set[i][1] = 2;
            set[i][2] = 0;
        }
        
        int K = sc.nextInt();
        for (int k = 0; k < K; k++) {
            int num = sc.nextInt()-1;
            int dir = sc.nextInt();
            boolean[] cho = new boolean[4];
            cho[num] = true;
            
            int num1 = num;
            while (--num1 >= 0) {
                if (arr[num1][set[num1][1]] != arr[num1+1][set[num1+1][0]])
                    cho[num1] = true;
                else break;
            }
            
            int num2 = num+1;
            while (num2 <= 3) {
                if (arr[num2-1][set[num2-1][1]] != arr[num2][set[num2][0]])
                    cho[num2] = true;
                else break;
                num2++;
            }

            int[] d;
            if (dir == 1 && num % 2 == 0 || dir == -1 && num % 2 == 1) d = d1;
            else d = d2;

            for (int i = 0; i < 4; i++) {
                if (cho[i]) {
                    set[i][0] = (set[i][0]+d[i]+8) % 8;
                    set[i][1] = (set[i][1]+d[i]+8) % 8;
                    set[i][2] = (set[i][2]+d[i]+8) % 8;
                }
            }
        }
        
        int z = 1;
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i][set[i][2]] == 1)
                sum += z;
            z*=2;
        }
        System.out.println(sum);
    }
}