import java.util.Scanner;

public class Solution {
 
    static int[] arr; // 각 열에 퀸이 위치한 행을 저장하는 배열
    static int N; // 체스판의 크기(NxN)
    static int count; // 해의 개수를 세는 변수
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
        	N = sc.nextInt(); // 체스판 크기를 입력받음
        	arr = new int[N]; // 각 열에 퀸의 위치를 저장할 배열 초기화
        	count = 0;
        	
        	NQueen(0); // 첫 번째 열부터 퀸을 배치하기 시작
        	System.out.println("#" + tc + " " + count); // 해의 개수 출력
		}
        sc.close();
    }
 
    // 퀸을 배치하는 메서드
    static void NQueen(int depth) {
        if (depth == N) { // 마지막 열까지 퀸을 배치한 경우
            count++; // 해의 개수 증가
            return;
        }
        
        for (int i = 0; i < N; i++) {
            arr[depth] = i; // 현재 열에 퀸을 i번째 행에 배치
            if (Possibility(depth)) // 퀸을 배치할 수 있는지 여부 확인
                NQueen(depth + 1); // 다음 열로 이동하여 퀸 배치 시도
        }
    }
 
    // 퀸을 배치할 수 있는지 여부를 확인하는 메서드
    static boolean Possibility(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) // 같은 행에 있는지 확인
                return false;
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) // 대각선에 있는지 확인
                return false;
        }
        return true; // 배치 가능한 경우
    }
}