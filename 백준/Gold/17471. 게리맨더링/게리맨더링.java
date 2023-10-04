import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, 결과 = Integer.MAX_VALUE;
	static int[] 인구;
	static boolean[] 선택된지역;
	static boolean[] 방문;
	static List<ArrayList<Integer>> 인접지역;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		인구 = new int[N];
		for (int i = 0; i < N; i++)
			인구[i] = sc.nextInt();
		
		인접지역 = new ArrayList<>();
		for (int i = 0; i < N; i++)
			인접지역.add(new ArrayList<Integer>());
		
		for (int i = 0; i < N; i++) {
			int M = sc.nextInt();
			for (int j = 0; j < M; j++)
				인접지역.get(i).add(sc.nextInt()-1);
		}
		
		for(int i = 0; i < 1<<N; i++) {
			선택된지역 = new boolean[N];
			for(int j = 0; j < N; j++) {
				if((i & 1<<j) != 0) 선택된지역[j] = true;
			}
			
			List<Integer> A지역 = new ArrayList<>();
			List<Integer> B지역 = new ArrayList<>();
			for (int k = 0; k < N; k++) {
				if (선택된지역[k])
					A지역.add(k);
				else
					B지역.add(k);
			}
			
			if (A지역.size() % N == 0) continue;
			
			if (연결됨(A지역) && 연결됨(B지역))
				인구수의차();
		}
		
		if (결과 == Integer.MAX_VALUE) 결과 = -1;
		System.out.println(결과);
		sc.close();
	}
	
	private static boolean 연결됨(List<Integer> 해당지역) {
		Queue<Integer> queue = new LinkedList<>();
		방문 = new boolean[N];
		방문[해당지역.get(0)] = true;
		queue.offer(해당지역.get(0));
		
		int count = 1;
		while (!queue.isEmpty()) {
			int poll = queue.poll();
			for (int i = 0; i < 인접지역.get(poll).size(); i++) {
				int y = 인접지역.get(poll).get(i);
				if(해당지역.contains(y) && !방문[y]) { 
					queue.offer(y);
					방문[y] = true;
					count++;
				}
			}
		}
		if(count==해당지역.size())
			return true;
		return false;
	}

	private static void 인구수의차() {
		int A인구수 = 0, B인구수 = 0;
		for (int i = 0; i < N; i++) {
			if (선택된지역[i])
				A인구수 += 인구[i];
			else
				B인구수 += 인구[i];
		}
		int 결과후보 = Math.abs(A인구수 - B인구수);
		결과 = Math.min(결과, 결과후보);
	}
}