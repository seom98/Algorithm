import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] a = new int[3][2];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = 0, y = 0;
        for (int i = 0; i < 3; i++) {
            x += a[i][0] * a[(i+1)%3][1];
            y += a[i][1] * a[(i+1)%3][0];
        }

        System.out.println(x-y == 0 ? 0 : x-y < 0 ? -1 : 1);
        br.close();
    }
}