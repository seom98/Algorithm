import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());

	// 첫번째로 받는 숫자가 N임.
	int N = Integer.parseInt(st.nextToken());

	for (int i = 1; i <= N; i++) { // N번 포문도는거임.
	    // 한줄을 받고 바로 " "를 기준으로 전부 나눠서 잘라서 배열에 넣음.
	    String[] arr = br.readLine().split(" ");

	    String[] rra = new String[arr.length];
	    for (int j = 0; j < arr.length; j++) { // 나눠진 단어들의 개수만큼 포문돎.

		rra[j] = arr[arr.length - j - 1];
	    }
	    System.out.println("Case #" + i + ": " + String.join(" ", rra));
	}
	// 이제 이친구들을 하나씩 출력함
    }
}
