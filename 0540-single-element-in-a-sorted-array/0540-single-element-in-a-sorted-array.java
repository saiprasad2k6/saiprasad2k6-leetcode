class Solution {
    public int singleNonDuplicate(int[] nums) {
        //Edge Cases
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int start = 0, end = n - 1, mid = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (start == end) { // When Start is same as End - there are no more iterations further.
                return nums[mid];
            } else if (nums[mid] == nums[mid + 1]) {     //When the Mid is same as next element
                if ((end - mid + 1) % 2 == 0) { //if length of right is even, go left
                    end = mid - 1;
                } else {
                    start = mid + 2; //if length of right is odd
                }

            } else if (nums[mid] == nums[mid - 1]) { //When mid is same as Prev
                if ((end - mid + 1) % 2 != 0) { //if length of right is even
                    end = mid - 2;
                } else {
                    start = mid + 1; //if length of right is odd
                }
            } else {
                return nums[mid];
            }
        }
        return 0;
    }
}