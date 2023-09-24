import java.util.Scanner;

public class Main {
	
	static int N, min = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		Backtracking(0, 0);
		System.out.println(min);
		sc.close();

	}
	static void  Backtracking(int index, int count) {
		if (count == N/2) {
			startLink();
			return;
		}
		
		for (int i = index; i < N; i++) {
			if(!visited[i]) { //백트래킹.
				visited[i] = true;	// 방문처리.
				Backtracking(i+1, count+1);	// 재귀탐.
				visited[i] = false;	//처리해제.
			}
		}
		
	}
	static void startLink() {
		int start = 0;
		int link = 0;
 
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				// i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스 
				if (visited[i] == true && visited[j] == true) {
					start += arr[i][j];
					start += arr[j][i];
				}
				// i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스 
				else if (visited[i] == false && visited[j] == false) {
					link += arr[i][j];
					link += arr[j][i];
				}
			}
		}
		// 두 팀의 점수 차이 (절댓값)
		int balance = Math.abs(start - link);
		
		/*
		 * 두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
		 * 더이상의 탐색 필요없이 0을 출력하고 종료하면 된다.
		 */
		if (balance == 0) {
			System.out.println(0);
			System.exit(0); //리턴하면 백트래킹함수로 돌아가므로 시스템을 종료하는 메소드를 써야함, 메인함수에서 리턴쓰는거랑 비슷함.
		}
		
		min = Math.min(balance, min);
			
	}
}