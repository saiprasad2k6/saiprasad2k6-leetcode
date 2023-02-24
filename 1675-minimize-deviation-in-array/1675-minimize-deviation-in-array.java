class Solution {
    /**
     * [4,1,5,20,3] ans = 3
     * 1. Make odd elements even , by multipying by 2
     * 2. Find the minimum of all elements
     * 3. Take the Max (through PQ). Find the diff = Max-Min, maintain a Min Variable
     * 4. Keep finding the diff until Max/2 is odd.
     */
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        //Check for Minimum, Make odd as even
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i % 2 == 1) i *= 2;
            min = Math.min(min, i);
            pq.add(i);
        }

        int diff = Integer.MAX_VALUE;
        //If the Max is Even, then remove it to find the diff. 
        while (pq.peek() % 2 == 0) {
            int max = pq.remove();
            diff = Math.min(diff, (max - min));
            min = Math.min(max / 2, min);
            pq.add(max / 2);
        }
        return Math.min(diff, pq.remove() - min);
    }
}