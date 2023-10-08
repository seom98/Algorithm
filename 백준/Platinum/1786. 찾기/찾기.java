import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] pi;
	static int cnt = 0;

	public static void search(String str, String pattern) {
		int sLen = str.length();
		int pLen = pattern.length();
		int index = 0;
		for (int i = 0; i < sLen; i++) {
			while (index > 0 && str.charAt(i) != pattern.charAt(index)) {
				index = pi[index - 1];
			}
			if (str.charAt(i) == pattern.charAt(index)) {
				if (index == pLen - 1) {
					sb.append(i - index + 1).append(" ");
					index = pi[index];
					cnt++;
				} else {
					index++;
				}
			}
		}
	}

	public static void makeTable(String pattern) {
		int pLen = pattern.length();
		pi = new int[pLen];

		int prefix = 0;
		for (int suffix = 1; suffix < pLen; suffix++) {
			while (prefix > 0 && pattern.charAt(suffix) != pattern.charAt(prefix)) {
				prefix = pi[prefix - 1];
			}
			if (pattern.charAt(suffix) == pattern.charAt(prefix)) {
				pi[suffix] = ++prefix;
			}
		}
	}

	static void make() throws IOException {
		String str = br.readLine();
		String pattern = br.readLine();

		makeTable(pattern);
		search(str, pattern);
		System.out.println(cnt);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		make();
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}