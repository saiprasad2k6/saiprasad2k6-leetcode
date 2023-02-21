class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int start = 0, end = n - 1, mid = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            //System.out.println("start=" + start + " mid=" + mid + " end=" + end);
            //When the Mid is same as next element
            if (start == end) return nums[mid];
            else if (nums[mid] == nums[mid + 1]) {
                //if length of right is even, go left
                if ((end - mid + 1) % 2 == 0) {
                    end = mid - 1;
                } else {
                    //if length of right is odd
                    start = mid + 2;
                }

            } else if (nums[mid] == nums[mid - 1]) { //When mid is same as Prev

                //if length of right is even
                if ((end - mid + 1) % 2 != 0) {
                    end = mid - 2;
                } else {
                    //if length of right is odd
                    start = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return 0;
    }
}