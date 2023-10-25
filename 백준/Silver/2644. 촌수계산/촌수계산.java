import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, start, end;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] dep;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        int M = sc.nextInt();
        visited = new boolean[N + 1];
        dep = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            dep[i] = -1;
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            list.get(u).add(v);
            list.get(v).add(u);
        }

        bfs();

        System.out.println(dep[end]);
    }// main

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        dep[start] = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int i = 0; i < list.get(poll).size(); i++) {
                int tmp = list.get(poll).get(i);

                if (!visited[tmp]) {
                    visited[tmp] = true;
                    dep[tmp] = dep[poll] + 1;
                    queue.add(tmp);
                }
            }
        }
    }
}