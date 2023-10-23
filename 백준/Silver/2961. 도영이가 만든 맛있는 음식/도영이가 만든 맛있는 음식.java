import java.util.Scanner;

public class Main {
	
	static int N, min = Integer.MAX_VALUE;
	static int[] sin, seun;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sin = new int[N];
		seun = new int[N];
		for (int i = 0; i < N; i++) {
			sin[i] = sc.nextInt();
			seun[i] = sc.nextInt();
		}
		visited = new boolean[N];
		
		dfs(0);
		
		System.out.print(min);
		
		sc.close();
	}
	static void dfs(int dep) {
		if (dep == N) {
			int x = 1;
			int y = 0;
			int count = 0;
			for (int i = 0; i < N; i++) {
				if(visited[i]) {
					x *= sin[i];
					y += seun[i];
					count++;
				}
			}
			if (Math.abs(x - y) < min && count > 0)
				min = Math.abs(x - y);
			return;
		}
		
		visited[dep] = true;
		dfs(dep+1);
		visited[dep] = false;
		dfs(dep+1);
	}
}