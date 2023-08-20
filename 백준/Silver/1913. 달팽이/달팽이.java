import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int xy = sc.nextInt();
        
        int xx = 0;
        int yy = 0;
        
        int[] dr = { 1, 0, -1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        int d = 0;
        
        int[][] snail = new int[N][N];
        
        int num = N*N;
        
        int x = 0;
        int y = 0;
        
        while (num > 0) {
        	snail[x][y] = num--;
        	
        	x += dr[d];
        	y += dc[d];
        	
        	if (x < 0 || y < 0 || x > N-1 || y > N-1 || snail[x][y] != 0) {
        		x -= dr[d];
            	y -= dc[d];
        		d = (d + 1) % 4;
        		x += dr[d];
            	y += dc[d];
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
               sb.append(snail[i][j] + " ");
               if (snail[i][j] == xy) {
                  xx = i + 1;
                  yy = j + 1;
               }
            }
            sb.append("\n");
         }

         sb.append(xx + " " + yy);
         System.out.println(sb);
    }
}
