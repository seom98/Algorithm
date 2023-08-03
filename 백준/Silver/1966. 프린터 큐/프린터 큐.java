import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            Queue<int[]> queue = new LinkedList<>();
            int max = 0;
            for (int j = 0; j < a; j++) {
                int x = sc.nextInt();
                if (x > max)
                    max = x;
                queue.add(new int[]{x, j}); // 0번째에 중요도, 1번째에 인덱스를 담음
            }

            int count = 0;
            while (true) {
                int[] item = queue.poll();
                int num = item[0];
                int index = item[1];

                if (num == max) {
                    count++;
                    if (index == b) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    queue.add(item);
                }

                // 큐에서 숫자를 꺼낼 때마다 max 값을 다시 계산
                max = queue.stream().mapToInt(arr -> arr[0]).max().orElse(0);
            }
        }
        sc.close();
    }
}
