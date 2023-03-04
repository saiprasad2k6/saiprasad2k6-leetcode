class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long count = 0;
        int start = 0, minStart = 0, maxStart = 0;
        boolean foundMin = false;
        boolean foundMax = false;
        for (int i = 0; i < n; i++) {
            //if outside the range
            if (nums[i] < minK || nums[i] > maxK) {
                foundMax = false;
                foundMin = false;
                start = i + 1;
            }

            //if = minK
            if (nums[i] == minK) {
                foundMin = true;
                minStart = i;
            }

            //if = maxK
            if (nums[i] == maxK) {
                foundMax = true;
                maxStart = i;
            }

            //compute the result
            if (foundMin && foundMax)
                count += (Math.min(minStart, maxStart)) - start + 1;

        }
        return count;
    }

}