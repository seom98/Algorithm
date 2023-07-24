import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] kgcmTable = new int[num][2];
        for (int i = 0; i < num; i++) {
            kgcmTable[i][0] = sc.nextInt();
            kgcmTable[i][1] = sc.nextInt();
        }

;        for (int i = 0; i < num; i++) {
            int conut = 1;
            for (int j = 0; j < num; j++) {
                if (i == j) continue;
                if (kgcmTable[i][0] < kgcmTable[j][0] && kgcmTable[i][1] < kgcmTable[j][1]) {
                    conut++;
                }
            }
            System.out.print(conut + " ");
        }

    }
}