import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		System.out.print("<");
		while (queue.size() != 1) {

			for (int i = 1; i <= K; i++) {

				if (i != K) {
					queue.add(queue.poll()); // 앞에서 뺀거 뒤에 넣기
				} else {
					System.out.print(queue.poll() + ", "); // 앞에서 빼면서 출력
				}

			}

		}

		System.out.print(queue.poll());
		System.out.print(">");


	}

}
