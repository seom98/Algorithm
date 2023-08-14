import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); //테스트케이스 갯수 
		
		for (int tc = 1; tc <= t; tc++) { //테스트케이스 만큼 반복 
			String string = sc.next(); //문자를 받음.
			char[] arr = string.toCharArray(); //문자를 char 배열로 바꿈.
			
			char[] rra = new char[arr.length]; //arr를 뒤집는 rra 배열을 만듦.
			for (int i = 0; i<arr.length; i++) {
				rra[arr.length-1-i] = arr[i]; //하나씩 넣어줌.
			}
			
			String gnirts = String.valueOf(rra); //rra배열을 합쳐줌. 
			
			System.out.println("#" + tc + " " + (string.equals(gnirts) ? 1 : 0)); // 같다면 1 다르면 0 출력
		}
		
	}
}