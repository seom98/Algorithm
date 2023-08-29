import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 에라토스테네스의 체 알고리즘
		boolean[] arr = new boolean[1000001];
		arr[1] = true; // 1은 소수가 아니다. 0은 검사하지 않는다.
		for (int i = 2; i < arr.length; i++) {
			int j = 2;
			while (i * j <= 1000000) {
				arr[i * j] = true; // i를 제외하고 i의 배수는 전부 true로 바꿔줌.
				j++;
			}
		}

		int A = sc.nextInt();
		int B = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();

		for (int i = A; i <= B; i++) {
			if (arr[i] == false) { // 소수일때.
				sb.append(i).append("\n");
			}

		}
		System.out.println(sb);
		sc.close();
	}
}