class Solution {
    public int findKthPositive(int[] arr, int k) {
        int last = arr[arr.length - 1];
        int i = 1, j = 0;

        //Loop from 1 to last # in the array, check if the # is same as arr[j]
        for (i = 1; i <= last; i++) {
            if (k == 0) break;
            if (i == arr[j]) {
                j++;
            } else {
                k--;
            }
        }

        //Edge Case where there are no missing #s but still we need to get the k #s after
        while (k > 0) {
            i++;
            k--;
        }

        return i - 1;
    }
}