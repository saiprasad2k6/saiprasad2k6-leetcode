class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long answer = 1;
        long left = 1;
        long right = Arrays.stream(time).min().orElse(0) * (long) totalTrips;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (getTimeTakenForExpectedTotalTrip(time, mid) < totalTrips) {
                left = mid+1;
                answer = left;
            } else {
                right = mid;
            }
        }
        return answer;
    }

    private long getTimeTakenForExpectedTotalTrip(int[] time, long expectedTripTime) {
        return Arrays.stream(time)
                .asLongStream()
                .reduce(0L, (calculatedTotalTripTime, currentTripTime) -> calculatedTotalTripTime + (expectedTripTime / currentTripTime));
    }
}