import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		
		//WB로시작하는 체스판
		String[][] chas = new String[8][8];
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				chas[i*2][j*2] = "W";
				chas[i*2][j*2+1] = "B";
				chas[i*2+1][j*2+1] = "W";
				chas[i*2+1][j*2] = "B";
			}
		}
		
		//입력받는 네모판
		String[][] squ = new String[a][b];
		for (int i = 0; i < a; i++) {
			squ[i] = sc.next().split("");
		}
		
		int count1;
		int count2;
		int min = 64;
		for (int i = 0; i < a-8+1; i++) {
			for (int j = 0; j < b-8+1; j++) {
				
				count1 = 0;
				for (int num1 = 0; num1 < 8; num1++) {
					for (int num2 = 0; num2 < 8; num2++) {
						if(squ[i+num1][j+num2].equals(chas[num1][num2])) {
							count1++;
						}
					}
				}
				count2 = 64 - count1;
				min = Math.min(min, Math.min(count1, count2));
				
			}
		}
		
		
		
		System.out.println(min);
		
	}

}