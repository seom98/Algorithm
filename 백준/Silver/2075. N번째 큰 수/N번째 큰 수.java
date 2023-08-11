import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				que.add(Integer.parseInt(st.nextToken()));
			}
		}

		int cnt = 1;
		while (true) {
			if (cnt == N) {
				System.out.print(que.poll() + " ");
				return;
			}
			que.poll();
			cnt++;
		}
	}
}