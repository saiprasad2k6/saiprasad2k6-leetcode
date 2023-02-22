class Solution {
    public int climbStairs(int n) {
        int[] DP = new int[n + 1];
        DP[0] = 1;
        DP[1] = 1;

        for (int i = 2; i < DP.length; i++) {
            DP[i] = DP[i - 2] + DP[i - 1];
        }

        return DP[DP.length - 1];
    }
}