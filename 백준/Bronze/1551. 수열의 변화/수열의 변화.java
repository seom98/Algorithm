import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine() , ",");
		int[] arr = new int[N];
		for(int i=0; i<arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int[] newArr = Arrays.copyOf(arr, arr.length);
		int arrLength = N-1;
		
		while(K != 0) {
			int[] moveArr = new int[arrLength];

			for(int i=0; i<newArr.length-1; i++) 
				moveArr[i] = newArr[i+1] - newArr[i];
			
			arrLength --;
			K --;
			newArr = Arrays.copyOf(moveArr, moveArr.length);
		}
		
		for(int i=0; i<newArr.length; i++) {
			if(i != newArr.length-1) 
				System.out.print(newArr[i]+",");
			else
				System.out.println(newArr[i]);
		}
		br.close();
	}

}