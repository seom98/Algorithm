import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//에라토스테네스의 체 알고리즘
		boolean[] arr = new boolean[1000001];
		arr[1] = true; //1은 소수가 아니다. 0은 검사하지 않는다.
		for (int i = 2; i < arr.length; i++) {
			int j = 2;
			while (i * j <= 1000000) {
				arr[i * j] = true; //i를 제외하고 i의 배수는 전부 true로 바꿔줌.
				j++;
			}
		}

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int cnt = 0;
			for (int i = A; i <= B; i++) {
				if (arr[i] == false) { //소수일때.
					String s = String.valueOf(i); 
					for (int j = 0; j < s.length(); j++) {
						if ((s.charAt(j) - '0') == D) { //그 소수에 해당숫자가 있다면 카운트하고 포문 브레이크 
							cnt++;
							break;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
		sc.close();
	}
}