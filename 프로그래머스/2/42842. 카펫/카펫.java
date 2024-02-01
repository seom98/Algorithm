
class Solution {
    public int[] solution(int b, int y) {
        int to = b+y;
        int[] a = new int[2];
        for (int i = 1; i <= (int)Math.sqrt(to); i++) {
            for (int j = to; j > 0; j--) {
                if(i*j == to && (i-2)*(j-2) == y) {
                    a[0] = j;
                    a[1] = i;
                }
            }
        }
        
        
        
        return a;
    }
}