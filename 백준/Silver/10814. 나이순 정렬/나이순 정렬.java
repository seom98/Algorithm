import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] age = new int[201];

		String[][] arr = new String[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.next();
			arr[i][1] = sc.next();
			age[Integer.parseInt(arr[i][0])]++;
		}

		for (int i = 1; i < 201; i++) {
			age[i] += age[i - 1];
		}

		String[][] ans = new String[N][2];
		for (int i = N - 1; i >= 0; i--) {
			ans[--age[Integer.parseInt(arr[i][0])]][0] = arr[i][0];
			ans[age[Integer.parseInt(arr[i][0])]][1] = arr[i][1];
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(ans[i][0]).append(" ").append(ans[i][1]).append("\n");
		}
			
		System.out.println(sb);
	}
}
