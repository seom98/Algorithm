import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) { //테스트케이스는 10개 
			int N = sc.nextInt();
			char[][] arr = new char[N][N];
			for (int j = 0; j < N; j++) { 
				for (int i = 0; i < N; i++) {
					arr[i][j] = sc.next().charAt(0); //세로로 입력받기. 
				}
			}
			
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N-1; j++) {
					if (arr[i][j] == '1') { //1이면 다음에 2가 있는지 검사하고 있으면 카운트.
						int k = j+1;
						while (k < N) {
							if (arr[i][k] == '2') {
								count++;
								j = k; //k가 늘어난만큼 앞으로 이동시켜줌.
								break;
							}
							k++;
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + count);
		}
		sc.close();
	}
}