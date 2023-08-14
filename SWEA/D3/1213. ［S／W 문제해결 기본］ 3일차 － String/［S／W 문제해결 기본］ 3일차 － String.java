import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = 10; // 테스트케이스 갯수
		for (int tc = 1; tc <= t; tc++) {
			int test = sc.nextInt();
			String string = sc.next(); // 찾을 문자열.
			String strong = sc.next(); // 검색할 문장. 길어서 스트롱임.

			int a = string.length(); // 찾을 문자열의 길이임.
			int b = strong.length(); // 문장의 길이임.

			int count = 0; //같은게 몇개인지 
			for (int i = 0; i <= b - a; i++) { //같은걸 찾아보자.
				int len = a; //찾을 문자열의 길이를 len에 저장.
				for (int j = 0; j < a; j++) { //찾을 문자열의 길이만큼 반복.
					if (strong.charAt(i + j) == string.charAt(j)) { //같다면len 에 -1 해줌.
						len--;
					}
				}
				if (len == 0) { //전부 같다면 0이 나오겠지. 
					count++; //같으니까 카운
				}
			}

			System.out.println("#" + test + " " + count);
		}
	}
}