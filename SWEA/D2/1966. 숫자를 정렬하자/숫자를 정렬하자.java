import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			int[] data = new int[N];
			for (int i = 0; i < N; i++) {
				data[i] = sc.nextInt();
			}
			// 삽입정렬 구현 : 배열을 이용해서 구현 해보자 입니다.
			for (int i = 1; i < data.length; i++) {
				int key = data[i]; // 이번에 정렬할 값.
				int j;
				// 넣을 위치를 찾는 for문
				// 뒤로 미는 for문
				for (j = i - 1; j >= 0 && key < data[j]; j--) {
					data[j + 1] = data[j];
				} // 넣을 위치를 찾고 뒤로 미는 작업까지 동시에 진행하겠다.
				data[j + 1] = key;
			} // 사이클 돌리기

			System.out.print("#" + tc + " ");
			for (int i = 0; i < data.length; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}

	}

}