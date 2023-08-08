import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[][] chbg = new int[8001][2];
		
		
		//최빈값을 찾기 위함.
		int aa = -4000;
		for (int i = 0; i< 8001; i++) chbg[i][0] = aa++;
		
		//중앙값. 최빈값, 맥스-민, 평균값 
		int max = -4001;
		int min = 4001;
		double add = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if(max < arr[i]) max = arr[i]; //맥스값
			if(min > arr[i]) min = arr[i]; //민값 
			chbg[arr[i]+4000][1]++; //최빈값 과정 
			add += arr[i]; //평균값 과정
		}

		Arrays.sort(arr);
		
		int ccc = 0; 
		int ccc1 = -4001;
		int ccc2 = -4001;
		for (int i = 8000; i >= 0; i--) {
			if (ccc < chbg[i][1]) {
				ccc2 = -4001;
				ccc = chbg[i][1];
				ccc1 = chbg[i][0];
			}
			if (ccc == chbg[i][1]) {
				ccc2 = ccc1;
				ccc = chbg[i][1];
				ccc1 = chbg[i][0];
			}
		}
		if (ccc2 == -4001) {
			System.out.println(Math.round(add/N) + "\n" + arr[N/2] + "\n" + ccc1 + "\n" + (max-min));
		} else {
			System.out.println(Math.round(add/N) + "\n" + arr[N/2] + "\n" + ccc2 + "\n" + (max-min));
		}

		sc.close();
	}
}
