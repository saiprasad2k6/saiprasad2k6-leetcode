class Solution {
    public int[] sortArray(int[] nums) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = priorityQueue.remove();
        }

        return nums;

    }
}