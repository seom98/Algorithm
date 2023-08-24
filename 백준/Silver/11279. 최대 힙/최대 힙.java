import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd != 0) {
                pq.add(-cmd);
            } else {
                if (pq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(-pq.poll() + "\n");
                }
            }
        }

        br.close();
        bw.close();
    }
}
