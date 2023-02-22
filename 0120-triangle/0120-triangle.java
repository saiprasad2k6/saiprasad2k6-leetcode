class Solution {


    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        int size = triangle.size();
        int min = Integer.MAX_VALUE;

        int[] sum = new int[size];
        ;
        sum[0] = triangle.get(0).get(0);
        for (int cur = 1; cur <= size - 1; cur++) {
            int next_size = triangle.get(cur).size();
            // it has to start with the end of the array
            // because the further one need the clean sum 
            // value than the newer one.
            for (int next = next_size - 1; next >= 0; next--) {
                if (next == 0) {
                    sum[0] = sum[0] + triangle.get(cur).get(next);
                } else if (next == (next_size - 1)) {
                    sum[next] = sum[next - 1] + triangle.get(cur).get(next);
                } else {
                    sum[next] = Math.min(sum[next - 1], sum[next]) + triangle.get(cur).get(next);
                }
            }
        }

        for (int i = 0; i < size; i++) {
            if (sum[i] < min) {
                min = sum[i];
            }
        }
        return min;
    }
}