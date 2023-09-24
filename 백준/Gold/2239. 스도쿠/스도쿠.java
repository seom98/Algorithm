import java.util.Scanner;

public class Main {

	static int[][] sudoku = new int[9][9];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			String s = sc.next();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = s.charAt(j) - '0';
			}
		}
		Backtracking(0, 0);
		sc.close();
	}

	static void Backtracking(int x, int y) {
		if (y == 9) {
			Backtracking(x + 1, 0);
			return;
		}
		if (x == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(sudoku[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		if (sudoku[x][y] == 0) {
			for (int num = 1; num <= 9; num++) {
				if (isPossibleNum(x, y, num)) { // 백트래킹.
					sudoku[x][y] = num; // 방문처리같은느낌쓰.
					Backtracking(x, y + 1); // 재귀탐.
				}
			}
			// 1부터 9까지 다 넣어봤는데 되는게 없다.. 
			// 분명 그전에서 틀린게 있다.. 
			//그렇기 때문에 0으로 바꿔주고 이전으로 돌아가자.
			sudoku[x][y] = 0; // 방문처리해제느낌쓰.
			return;
		}
		Backtracking(x, y + 1);
	}

	static boolean isPossibleNum(int x, int y, int num) {

		// 같은 행에 있는 원소들 중 겹치는 열 원소가 있는지 검사
		for (int i = 0; i < 9; i++) {
			if (sudoku[x][i] == num) {
				return false;
			}
		}

		// 같은 열에 있는 원소들 중 겹치는 행 원소가 있는지 검사
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][y] == num) {
				return false;
			}
		}

		// 3*3 칸에 중복되는 원소가 있는지 검사
		for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
			for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
				if (sudoku[i][j] == num) {
					return false;
				}
			}
		}

		return true; // 중복되는 것이 없을 경우 true 반환
	}
}