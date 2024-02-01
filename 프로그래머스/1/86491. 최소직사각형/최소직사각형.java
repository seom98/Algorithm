class Solution {
    public int solution(int[][] s) {
        int b = 0;
        int c = 0;
        for (int i = 0; i < s.length; i++) {
            int left = s[i][0] > s[i][1] ? s[i][0] : s[i][1];
            int right = s[i][0] > s[i][1] ? s[i][1] : s[i][0];
            b = left > b ? left : b;
            c = right > c ? right : c;
        }
        return b*c;
    }
}