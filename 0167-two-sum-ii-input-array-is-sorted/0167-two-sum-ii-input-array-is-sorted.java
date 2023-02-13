class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int x = 0;
        int y = numbers.length - 1;

        while (true) {
            int sum = numbers[x] + numbers[y];
            if (sum == target) {
                break;
            } else if (sum < target) {
                x++;
            } else {
                y--;
            }
        }
        return new int[]{x+1, y+1};
    }
}