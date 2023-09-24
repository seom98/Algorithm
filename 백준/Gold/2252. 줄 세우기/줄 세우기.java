import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int V = sc.nextInt();
		int E = sc.nextInt();
		List<List<Integer>> adjList = new ArrayList<>();
		int[] degree = new int[V + 1];

		for (int i = 0; i <= V; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adjList.get(A).add(B);
			degree[B]++;
		}

		for (int i = 1; i <= V; i++) {
			if (degree[i] == 0)
				queue.add(i);
		}

		while (!queue.isEmpty()) {
			int work = queue.poll();
			sb.append(work).append(" ");

			for (int i : adjList.get(work)) {
				degree[i]--;
				if (degree[i] == 0)
					queue.add(i);
			}
		}
		System.out.println(sb);

		sc.close();
	}
}