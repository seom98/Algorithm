import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char c = sc.next().charAt(0);
		String s = "";
		switch (c) {
		case 'M':
			s = "MatKor";
			break;
		case 'W':
			s = "WiCys";
			break;
		case 'C':
			s = "CyKor";
			break;
		case 'A':
			s = "AlKor";
			break;
		case '$':
			s = "$clear";
			break;
		}
		System.out.println(s);
		sc.close();
	}

}