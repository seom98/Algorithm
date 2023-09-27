import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
			int M = sc.nextInt();
			int[] arr = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			int[] a = new int[8];
			for (int i = 0; i < 8; i++) {
				if (M / arr[i] > 0) {
					a[i] += M / arr[i];
					M = M % arr[i];
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append("\n");
			for (int i = 0; i < 8; i++) {
				sb.append(a[i]).append(" ");
			}
			System.out.println(sb);
        }
        sc.close();
    }

 
}