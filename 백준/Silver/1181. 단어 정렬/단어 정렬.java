import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashSet<String> hs = new HashSet<>();
		for (int i =0; i < N; i++) {
			hs.add(sc.next());
		}
		List<String> li = new ArrayList<>(hs);

		Collections.sort(li);
		Collections.sort(li, (o1, o2) -> o1.length() - o2.length());

		StringBuilder sb = new StringBuilder();
		for (String a : li) {
			sb.append(a).append("\n");
		}	
		System.out.println(sb);
	}
}
