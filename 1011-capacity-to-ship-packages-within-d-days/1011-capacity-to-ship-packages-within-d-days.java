class Solution {
    int minimumCapacity = 0;

    public int shipWithinDays(int[] weights, int days) {
        //Edge Cases
        if (weights.length == 0) return 0;

        //Binary Search
        findMinimumCapacity(weights, 0, Integer.MAX_VALUE, days);
        return minimumCapacity;
    }


    private void findMinimumCapacity(int[] weights, int start, int end, int days) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (checkForCapacity(weights, mid, days)) {
                minimumCapacity = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }

    private boolean checkForCapacity(int[] weights, int capacity, int days) {
        int countOfDays = 1;
        int totalWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > capacity) return false;

            totalWeight += weights[i];

            if (totalWeight > capacity) {
                countOfDays++;
                totalWeight = weights[i];
            }

            if (countOfDays > days) return false;
        }

        return true;
    }
}