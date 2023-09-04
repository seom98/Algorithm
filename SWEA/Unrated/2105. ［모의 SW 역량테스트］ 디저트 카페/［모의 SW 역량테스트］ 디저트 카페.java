import java.io.*;
import java.util.*;

public class Solution {

	static int N, x, y, sum;
	static int[][] arr;
	static int[] dc = { 1, -1, -1, 1 };
	static int[] dr = { 1, 1, -1, -1 };
	static Set<Integer> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			set = new HashSet<>();
			sum = -1;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					x = i;
					y = j;
					dessert(i, j, 0, 0, 0);
					set.clear();
				}
			}
			bw.write("#" + t + " " + sum + "\n");
		}
		br.close();
		bw.close();
	}

	static void dessert(int a, int b, int c, int s, int n) {
		if (c == 3 && a == x && b == y) {
			if (sum < s)
				sum = s;
			return;
		}
		
		if (n < 0) return;
		if (c == 0 || c == 1) n++;
		else n--;

		if (a >= 0 && b >= 0 && a < N && b < N && !set.contains(arr[a][b])) {
			set.add(arr[a][b]);
			if (c < 3) {
				dessert(a + dr[c], b + dc[c], c, s + 1, n);
				dessert(a + dr[c + 1], b + dc[c + 1], c + 1, s + 1, n);
			} else {
				dessert(a + dr[c], b + dc[c], c, s + 1, n);
			}
			set.remove(arr[a][b]);
		}
	}
}