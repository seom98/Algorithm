import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, K, ans, subin;
	static int[][] move = {{1, -1}, {1, 1}, {2, 0}}; 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		BFS();
		
		System.out.print(ans);
		sc.close();
	}
	static void BFS() {
		boolean[] visited = new boolean[100001];
		int[] count = new int[100001];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		count[N] = 0;

		while (!queue.isEmpty()) {
			subin  = queue.poll();
			if (subin  == K) {
				ans = count[subin];
				return;
			}
			
			for (int i = 0; i < 3; i++) {
				if(teleport(i)>=0 && teleport(i)<=100000 && !visited[teleport(i)]) {
					visited[teleport(i)] = true;
					count[teleport(i)] = count[subin] + 1;
					queue.add(teleport(i));
				}	
			}
		}
	}
	static int teleport(int i) {
		return subin*move[i][0]+move[i][1];
	}
}