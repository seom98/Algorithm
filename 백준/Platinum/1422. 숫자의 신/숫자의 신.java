import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		String[][] arr = new String[M][2];
		boolean flag = false;
		int max = 0;
		for (int i = 0 ; i < M; i++) {
			if (i < N) {
				String x = sc.next();
				if (max < Integer.parseInt(x)) {
					max = Integer.parseInt(x);
				}
				StringBuilder ssb = new StringBuilder();
				for (int j = 0; j < 10; j++) {
					ssb.append(x.charAt(j%x.length()));
				}
				arr[i][0] = ssb.toString();
				arr[i][1] = x;
				if(Long.parseLong(x)!=0) 
					flag = true;
			} else {
				String x = String.valueOf(max);
				StringBuilder ssb = new StringBuilder();
				for (int j = 0; j < 10; j++) {
					ssb.append(x.charAt(j%x.length()));
				}
				arr[i][0] = ssb.toString();
				arr[i][1] = x;
				if(Long.parseLong(x)!=0) 
					flag = true;
			}
		}
		if(flag==false) {
			System.out.println("0");
			return;
		}
		
		Arrays.sort(arr, (a,b)->{
			return b[0].compareTo(a[0]);
		});

		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
				sb.append(arr[i][1]);
		}
		
		System.out.println(sb);
	}
}