import java.util.Scanner;

public class Main {

	static int N, M, ans = 0; // 행, 열, 정답
	static int[][] arr;
	static boolean[] visited = new boolean[26]; // 알파벳개수만큼 방문체크 배열
	static int[] drow = { -1, 1, 0, 0 }; // 상하좌우 이동 
	static int[] dcol = { 0, 0, -1, 1 }; 

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++)
				arr[i][j] = str.charAt(j) - 'A'; // 알파벳을 숫자로 변환하여 배열에 저장
		}

		alpabet(0, 0, 0); //무조건 0,0에서 시작해서 이렇게 적으면 됨.

		if (N == 1 && M == 1) {
			System.out.println(1);
		} else {			
			System.out.println(ans);
		}
		sc.close();
	}

	public static void alpabet(int i, int j, int count) {
		if (visited[arr[i][j]]) { // 이미 방문한 알파벳을 만난 경우.
			if (ans < count) ans = count; // 더 긴 길이이면 정답 갱신해줌.
			return;
		} else {
			for (int d = 0; d < 4; d++) {
				int x = i + drow[d];
				int y = j + dcol[d];

				if (x >= 0 && y >= 0 && x < N && y < M) { // 엘스문이라서 범위내에 있는 것만 확인하면 됨.
					visited[arr[i][j]] = true; // 현재 알파벳 방문체크 
					alpabet(x, y, count + 1); // 카운트한칸 늘리고 재귀탐.
					visited[arr[i][j]] = false; // 백트래킹 
				}
			}
		}
	}
}