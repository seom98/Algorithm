import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N, manjok;
	static int[][] arr, check;
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };
	static List<int[]> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N]; // 교실책상
		check = new int[N][N];
		int stu = N*N; // 학생수
		list = new ArrayList<>(); // 학생넘버와 좋아하는 학생 담아두는 리스트

		for (int i = 0; i < stu; i++) {
			int[] a = new int[5];
			for (int j = 0; j < 5; j++)
				a[j] = sc.nextInt();
			list.add(a);
			best(i); // 자리를 찾아주는 메소드
		}

		manjok = 0; // 만족도
		for (int s = 0; s < stu; s++) {
			mj(s); // 학생의 만족도를 찾아주는 메소드
		}
		System.out.println(manjok);
//		print();
		sc.close();
	}

	// 학생넘버가 들어있는 번째를 넣으면 0인칸 중에서 젤 좋은 곳인 곳으로 인트배열 찾아줌.
	// 일단 인접한곳에 좋아하는학생있으면 1000점 추가
	// 주변에 0이 있는만큼 100점 추가
	// 행이 빠를수록 10점 추가
	// 열이 빠를수록 1점 추가
	static void best(int student) {
		int maxSum = 0;
		int bestX = 0;
		int bestY = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) { // 0인곳만 보는거임.
					int sum = (N - i) * 100 + (N - j); // 우선 행과 열에 대한 점수를 추가함.
					for (int d = 0; d < 4; d++) { // 방향을 탐색함.
						int x = i + drow[d];
						int y = j + dcol[d];

						if (x >= 0 && x < N && y >= 0 && y < N) { // 범위내에 있을때
							if (arr[x][y] == 0)
								sum += 10000;
							else {
								for (int s = 1; s <= 4; s++) {
									if (arr[x][y] == list.get(student)[s]) // 그자리에 좋아하는 학생이 있을경우.
										sum += 100000;
								}
							}
						}
					}
					if (maxSum < sum) { // 최대값경신
						maxSum = sum;
						bestX = i;
						bestY = j;
					}
				}
			}
		}
		check[bestX][bestY] = student;
		arr[bestX][bestY] = list.get(student)[0];
	}

	static void mj(int student) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == list.get(student)[0]) { //해당하는 학생을 찾음.
					int count = 0;
					for (int d = 0; d < 4; d++) {
						int x = i + drow[d];
						int y = j + dcol[d];

						if (x >= 0 && x < N && y >= 0 && y < N) { 
							for (int n = 1; n <= 4; n++) {
								if (arr[x][y] == list.get(student)[n]) //주변에 내가 좋아하는 학생이 있을때마다 카운트.
									count++;
							}
						}
					}
					switch (count) {
					case 0:
						manjok += 0;
						break;
					case 1:
						manjok += 1;
						break;
					case 2:
						manjok += 10;
						break;
					case 3:
						manjok += 100;
						break;
					case 4:
						manjok += 1000;
						break;
					}
					return;
				}
			}
		}
	}

	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}