import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		int i = 0;
		while (queue.size() != 0) {
			if (i % 2 == 1) {
				queue.add(queue.poll()); // 앞에서 뺀거 뒤에 넣기
			} else {
				System.out.print(queue.poll() + " "); // 앞에서 빼면서 출력
			}
			i++;
		}
	}
}
