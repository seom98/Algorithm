class Solution {
    public int solution(int[] n) {
        int a = 45;
        for (int i : n) a -= i;
        return a;
    }
}