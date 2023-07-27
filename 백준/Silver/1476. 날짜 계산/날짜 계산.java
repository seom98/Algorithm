import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

 	    int num1 = Integer.parseInt(st.nextToken());
	    int num2 = Integer.parseInt(st.nextToken());
	    int num3 = Integer.parseInt(st.nextToken());
	
	    int i = 1;
	    while (true) {
	        if ((i % 15) == (num1 % 15) && i % 28 == (num2 % 28) && i % 19 == (num3 % 19)) {
		        System.out.print(i);
		        break;
            }
            i++;
	    }
	}
}