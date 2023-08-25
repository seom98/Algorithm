import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine(), "< >", true);
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while (st.hasMoreTokens()) {
			String str = st.nextToken();
			if (!str.equals("<")) {
				sb.append(str);
				sb.reverse();
				sb2.append(sb);
				sb.setLength(0);
			} else {
				sb2.append(str);
				while (st.hasMoreTokens()) {
					String str2 = st.nextToken();
					if (!str2.equals(">")) {
						sb2.append(str2);
					} else {
						sb2.append(str2);
						break;
					}
				}
			}
		}
		System.out.println(sb2);
		sc.close();
	}
}