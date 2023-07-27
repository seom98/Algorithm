import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int[] arr = new int[num];
        int count = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for(int i = num-1; i >= 1; i--) {
            max = 0;
            for(int j = 0; j < i; j++) {
                max = Math.max(max, arr[j]);
            }
            for(int j = 0; j < i; j++) {
                if(arr[j] == max && arr[i] < arr[j]) {
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    count--;
                    if (count == 0) {
                        System.out.print(arr[j] + " " + arr[i]);
                        break;
                    }
                }
            }
        }
        if (count > 0) {
            System.out.print(-1);
        }
    }
}
