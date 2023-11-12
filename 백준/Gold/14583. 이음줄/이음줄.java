import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private void solve() {
		double h = sc.nextDouble();
		double v = sc.nextDouble();
		double d = Math.sqrt(h * h + v * v);
		double a = v * (h / (h + d));
		double b = v * (d / (h + d));
		double c = Math.sqrt(a * a + h * h);

		System.out.format("%.2f", c / 2);
		System.out.print(" ");
		System.out.format("%.2f", (b * h) / c);
	}

	public static void main(String[] args) {
		sc.init();
		new Main().solve();
	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;
		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}
		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
			}
			return null;
		}
		static String readLineReplace() {
			try {
				return br.readLine().replaceAll("\\s+", "");
			} catch (IOException e) {
			}
			return null;
		}
		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}
		static int nextInt() {
			return Integer.parseInt(next());
		}
		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}