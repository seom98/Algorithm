import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int m = Integer.toString(n).length();
        for (int i = 0; i < m; i++) {
            answer += n%10;
            n = n/10;
        }
        return answer;
    }
}