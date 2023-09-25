import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static int[] p; // 대표를 저장할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        p = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            p[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int a = sc.nextInt();
                if (i != j && a == 1) {
                    int nx = findset(i);
                    int ny = findset(j);
                    if (nx != ny) {
                        union(nx, ny);
                    }
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            p[i] = findset(p[i]);
        }
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 1; i <= M; i++) {
            hash.add(p[sc.nextInt()]);
        }

        if (hash.size() == 1) {
            System.out.println("YES");
        } else
            System.out.println("NO");

    }

    static void union(int x, int y) {
            p[y] = x;
    }

    static int findset(int x) {
        if (x != p[x])
            p[x] = findset(p[x]);
        return p[x];
    }
}