/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    int result = 0;

    public int firstBadVersion(int n) {
        checkForBadVersion(1, n);
        return result;
    }

    private boolean checkForBadVersion(int start, int end) {
        if (start > end) return false;

        int mid = start + (end-start) / 2;

        if (isBadVersion(mid)) {
            result = mid;
            return checkForBadVersion(start, mid - 1);
        } else {
            return checkForBadVersion(mid + 1, end);
        }
    }
}