import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K, ans, location;
	static boolean[] visited = new boolean[100001]; // 방문 여부를 체크하는 배열
	static int[] second = new int[100001]; // 위치까지 도달하는데 걸린 시간을 저장하는 배열
	static int[][] move = { { 2, 0 }, { 1, -1 }, { 1, 1 } }; // 이동할 수 있는 방법을 정의한 배열
	static Queue<Integer> queue = new LinkedList<>(); // BFS를 위한 큐

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 수빈이의 현재 위치
		K = sc.nextInt(); // 동생의 위치

		BFS(); // BFS 알고리즘을 통해 최단 시간을 구함

		System.out.print(ans);
		sc.close();
	}

	static void BFS() {
		queue.add(N); // 수빈이의 현재 위치를 큐에 넣음

		while (!queue.isEmpty()) {
			location = queue.poll(); // 큐에서 위치를 하나 꺼냄
			if (location == K) {
				ans = second[location]; // 현재 위치가 동생의 위치와 같다면 정답을 설정하고 종료
				return;
			}

			for (int i = 0; i < 3; i++) {
				int tp = teleport(i); // 이동할 위치 계산
				if (tp >= 0 && tp <= 100000 && !visited[tp]) {
					visited[tp] = true; // 이동한 위치를 방문했다고 표시
					if (i == 0)
						second[tp] = second[location];
					else
						second[tp] = second[location] + 1; // 다음 위치까지 도달하는데 걸린 시간을 업데이트
					queue.add(tp); // 다음 위치를 큐에 추가
				}
			}
		}
	}

	static int teleport(int i) {
		return location * move[i][0] + move[i][1];
	}
}