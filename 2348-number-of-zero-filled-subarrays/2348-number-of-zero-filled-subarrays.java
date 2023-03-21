class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int countOfConsecutive = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countOfConsecutive++;
            } else {
                countOfConsecutive = 0;
            }
            sum += countOfConsecutive;
        }
        return sum;
    }
}