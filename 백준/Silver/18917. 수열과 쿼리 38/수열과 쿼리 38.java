import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int M = Integer.parseInt(br.readLine());
        long sum = 0, res = 0;
        
        for(int i = 0; i < M; i++) {
            String[] str = br.readLine().split(" ");

            int cmd = Integer.parseInt(str[0]);
            int oper = 0;

            if(str.length != 1) oper = Integer.parseInt(str[1]);

            if(cmd == 1) {
                sum += oper;
                res ^= oper;
            } else if(cmd == 2) {
                sum -= oper;
                res ^= oper;
            } else if(cmd == 3) sb.append(sum +"\n");
            else sb.append(res +"\n");
        }

        System.out.println(sb);
    }
}