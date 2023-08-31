import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			N = sc.nextInt();
			
			if (N == 0) {
				System.out.println(sb);
				sc.close();
				return;
			}
			
			arr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			Arrays.sort(arr);

			result = new int[6];
			visited = new boolean[N];
			lotto(0, 0);
			sb.append('\n');
		}

	}

	static void lotto(int start, int depth) {
		if (depth == 6) {
			for (int element : result)
				sb.append(element).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				lotto(i, depth + 1);
				visited[i] = false;
			}
		}
	}
}