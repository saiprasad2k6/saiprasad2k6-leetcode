class Solution {
    /**
     * Notes: Bitwise AND of n and n-1 must be 0
     * e.g. 7,8
     * 8 is a power of 2.
     * 
     * bit representation of 7  -> 0111
     * bit representation of 8  -> 1000
     * bitwise AND of 7 and 8 -> 0000
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return ((n & (n - 1)) == 0);
    }
}