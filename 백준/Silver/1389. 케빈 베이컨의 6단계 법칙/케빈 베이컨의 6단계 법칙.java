import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visited;
	static int[] dep;

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		dep = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			if (list.get(u).contains(v))
				continue;
			else {
				list.get(u).add(v);
				list.get(v).add(u);
			}
		}

		for (int i = 0; i < list.size(); i++)
			Collections.sort(list.get(i));

		int min = (100 * 99) / 2 + 1;
		int person = 0;

		for (int i = 1; i < N + 1; i++) {
			visited = new boolean[N + 1];
			bfs(i);

			int sum = 0;
			for (int j = 0; j < N + 1; j++)
				sum += dep[j];
			if (sum < min) {
				min = sum;
				person = i;
			}
		}
		System.out.println(person);
	}

	static void bfs(int t) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(t);
		visited[t] = true;
		dep[t] = 0;

		while (!q.isEmpty()) {
			int take = q.poll();

			for (int i = 0; i < list.get(take).size(); i++) {
				int tmp = list.get(take).get(i);

				if (visited[tmp] == false) {
					visited[tmp] = true;
					dep[tmp] = dep[take] + 1;
					q.offer(tmp);
				}
			}
		}
	}
}