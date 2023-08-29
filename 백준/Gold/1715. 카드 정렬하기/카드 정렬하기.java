import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		int N = sc.nextInt();
		
		for (int i = 0; i <N; i++) {
			pq.add(sc.nextInt());
		}
		int count = 0;
		for (int i = 0; i < N-1; i++) {
			int a = pq.poll();
			int b = pq.poll();
			int c = a+b;
			count+= c;
			pq.add(c);
		}
		
		System.out.println(count);
		sc.close();
	}

}