import java.util.Scanner;

public class Main {

	public static int[] nums;
	public static int N, M;
	public static int[] result;
	public static boolean[] visited;
	public static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N];
		for (int i = 1; i <= N; i++) {
			nums[i - 1] = i;
		}
		M = sc.nextInt();
		result = new int[M];
		visited = new boolean[N];
		sb = new StringBuilder();
		NM(0, 0);
		System.out.println(sb);
		sc.close();
	}

    static void NM(int start, int depth) {
        if (depth == M) {
            for (int element : result)
                sb.append(element).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) { 
                visited[i] = true;
                result[depth] = nums[i]; 
                NM(i, depth + 1); 
                visited[i] = false;
            }
        }
    }
}