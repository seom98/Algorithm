import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	static int N, x, y, sum;
	static int[][] arr;
	static int[] dc = {1, -1, -1, 1};
	static int[] dr = {1, 1, -1, -1};
	static Set<Integer> set;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			set = new HashSet<Integer>();
			sum = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < N-2; i++) {
				for (int j = 1; j < N-1; j++) {
					x = i;
					y = j;
					dessert(i, j, 0, 0);
					set.clear();
				}
			}

			System.out.println("#" + t + " " + sum);
		}
		sc.close();
	}
	
	static void dessert(int a, int b, int c, int s) {
		//기저조건
		if (c == 3 && a == x && b == y) {
			if (sum < s) sum = s;
			return;
		}
		
		if (a >= 0 && b >= 0 && a < N && b < N && c < 3 && !set.contains(arr[a][b])) {
			set.add(arr[a][b]);
			dessert(a+dr[c], b+dc[c], c, s+1);
			dessert(a+dr[c+1], b+dc[c+1], c+1, s+1);
			set.remove(arr[a][b]);
		}
		if (a >= 0 && b >= 0 && a < N && b < N && c == 3 && !set.contains(arr[a][b])) {
			set.add(arr[a][b]);
			dessert(a+dr[c], b+dc[c], c, s+1);
			set.remove(arr[a][b]);
		}
		
	}
}