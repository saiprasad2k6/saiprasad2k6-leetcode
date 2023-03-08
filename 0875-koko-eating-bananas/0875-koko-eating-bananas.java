class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;

        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (calculateEatingTimeForSpeed(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int calculateEatingTimeForSpeed(int[] piles, int expectedSpeed) {
        if (expectedSpeed == 0) return piles[0];

        int n = piles.length;
        int i = 0;
        int time = 0;
        int eatingTime = 0;
        while (i < n) {
            eatingTime += piles[i] / expectedSpeed;
            if (piles[i] % expectedSpeed != 0)
                eatingTime++;
            i++;
        }

        return eatingTime;

    }
}