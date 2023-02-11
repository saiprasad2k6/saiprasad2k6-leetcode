class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, (nums.length - 1), target);
        
    }

    private int search(int[] nums, int start, int end, int target) {
        // Base Case
        if(start > end) return -1;
        
        int n = (start + end) / 2;
        if (nums[n] == target) {
            return n;
        }

        if (target < nums[n]) {
            return search(nums, start, n - 1, target);
        } else {
            return search(nums, n + 1, end, target);
        }
    }
}