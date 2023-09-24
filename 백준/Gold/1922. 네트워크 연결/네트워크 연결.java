import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] edges = new int[E][3];
        arr = new int[V+1];
        for (int i = 0; i < V+1; i++)
        	arr[i] = i;

        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        Arrays.sort(edges, (o1, o2) -> o1[2] - o2[2]);

        int ans = 0;
        int pick = 0;
        for (int i = 0; i < E; i++) {
            int px = findset(edges[i][0]);
            int py = findset(edges[i][1]);
            if (px != py) {
                union(px, py);
                ans += edges[i][2];
                pick++;
            }
            if (pick == V - 1)
                break;
        }
        System.out.println(ans);
        sc.close();
    }

    static void union(int x, int y) {
        arr[y] = x; 
    }

    static int findset(int x) {
        if (x != arr[x])
            arr[x] = findset(arr[x]);
        return arr[x];
    }
}