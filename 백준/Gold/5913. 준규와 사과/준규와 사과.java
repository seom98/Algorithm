import java.util.Scanner;

public class Main {
    
    static int count = 0;
    static int[][] map = new int[5][5]; // 농장
    static int K;
    static int max = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        K = sc.nextInt();
        
        for ( int i = 0; i < K; i++ ){
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x-1][y-1] = -1; // 돌덩이 표시 - 갈 수 없음
        }
        
        DFS(0,0,1);
        
        System.out.println(count);
        
    }
    
    private static void DFS( int x, int y, int size ){
        if ( x == 4 && y == 4 ){
            if ( size == 25-K ){
                count++;
            }
            if ( max < size ){
                max = size;
            }
        }
        map[y][x] = -1; 
        
        if (y > 0 && map[y - 1][x] != -1)
            DFS(x, y - 1, size + 1);
          // 아래로 이동할 수 있다면 이동!
        if (y < 4 && map[y + 1][x] != -1)
            DFS(x, y + 1, size + 1);
          // 왼쪽으로 이동할 수 있다면 이동!
        if (x > 0 && map[y][x - 1] != -1)
            DFS(x - 1, y, size + 1);
          // 오른쪽으로 이동할 수 있다면 이동!
        if (x < 4 && map[y][x + 1] != -1)
            DFS(x + 1, y, size + 1);
 
        map[y][x] = 0; // 지나간 자리 원상태로 되돌리기
    }
 
}