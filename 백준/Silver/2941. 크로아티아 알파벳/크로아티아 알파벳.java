import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String croa = sc.next();
		int len = croa.length();

		for (int i = 1; i < croa.length(); i++) {
			if (croa.charAt(i) == '-') {
				len--;
			}
			if (croa.charAt(i) == '=') {
				if (croa.charAt(i - 1) == 's' || croa.charAt(i - 1) == 'c') {
					len--;
				} else if (croa.charAt(i - 1) == 'z') {
					if (i > 1 && croa.charAt(i - 2) == 'd') {
						len--;
						len--;
					} else {
						len--;
					}
				}
			}
			if (croa.charAt(i) == 'j') {
				if (croa.charAt(i - 1) == 'l' || croa.charAt(i - 1) == 'n') {
					len--;
				}
			}
		}
		System.out.println(len);

		sc.close();
	}
}
