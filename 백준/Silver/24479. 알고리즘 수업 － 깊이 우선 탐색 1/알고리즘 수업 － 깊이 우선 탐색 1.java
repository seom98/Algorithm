import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    // 그래프를 표현하는 리스트
    static List<List<Integer>> graph = new ArrayList<>();
    // 방문 여부를 나타내는 배열
    static int[] visited;
    // 방문 순서를 나타내는 변수
    static int count = 1;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수
        int R = sc.nextInt(); // 시작 정점

        // 그래프 초기화
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt(); // 간선의 시작 정점
            int v = sc.nextInt(); // 간선의 끝 정점
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new int[N + 1]; // 방문 여부 배열 초기화

        // 각 정점의 인접 정점 리스트 정렬
        for (int i = 1; i <= N; i++)
            Collections.sort(graph.get(i));

        DFS(R); // 깊이 우선 탐색 수행

        // 결과 출력
        for (int i = 1; i <= N; i++)
            sb.append(visited[i]).append("\n");
        
        System.out.println(sb.toString());
        sc.close();
    }

    // 깊이 우선 탐색 함수
    static void DFS(int node) {
        visited[node] = count;

        for (int nearNode : graph.get(node)) {
            if (visited[nearNode] == 0) {
                count++;
                DFS(nearNode);
            }
        }
    }
}