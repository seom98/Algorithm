import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int count;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		count = 0;
		visited = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++)
			graph.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			int com1 = sc.nextInt();
			int com2 = sc.nextInt();
			graph.get(com1).add(com2);
			graph.get(com2).add(com1);
		}

		DFS(1);

		System.out.println(count);
		sc.close();
	}

	public static void DFS(int i) {
		visited[i] = true;
		for (int x : graph.get(i)) {
			if (!visited[x]) {
				count++;
				DFS(x);
			}
		}
	}

}