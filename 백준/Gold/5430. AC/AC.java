import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			char[] RD = sc.next().toCharArray();
			int M = RD.length;
			int N = sc.nextInt();
			int[] num = new int[N];
			StringTokenizer st = new StringTokenizer(sc.next(), ",[]");
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			int start = 0;
			int end = N-1;
			int RCount = 0;
			for (int i = 0; i < M; i++) {
				// 뒤집는 부분
				if (RD[i] == 'R') {
					if (RCount == 0) RCount++;
					else RCount--;
				} 
				
				// 하나 빼는 부분
				else {
					if (RCount == 0) start++;
					else end--;
				}
			}
			if (end - start < -1) {
				System.out.println("error");
			} else {				
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				if (RCount == 0) {
					for (int i = start; i < end+1; i++) {
						if (i != end) sb.append(num[i]).append(",");
						else sb.append(num[i]);
					}
				} else {
					for (int i = end; i > start-1; i--) {
						if (i != start) sb.append(num[i]).append(",");
						else sb.append(num[i]);
					}
				}
				sb.append("]");
				System.out.println(sb);
			}
		}
	}
}