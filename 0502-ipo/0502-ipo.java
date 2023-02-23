class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        //Create the Projects Array for Sorting it based on Minimal Capital
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        //Sort the Projects - such that the element with least capital comes first
        // Here a and b are elements of projects[], each a will contain a[0],b[0] ==> capital
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));

        //Create a maxHeap using Priority Queue.
        PriorityQueue<Integer> maximumCapital = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        while (k-- > 0) { // Until the # of selected items is met
            //untill we reach the length, check for cost that is less than available capital.
            //Add such projects to maxHeap
            while (i < n && projects[i][0] <= w) {
                maximumCapital.offer(projects[i][1]);
                i++;
            }
            if (maximumCapital.isEmpty()) { // Break up when the Max Heap is empty
                break;
            }

            w += maximumCapital.poll(); // add the max profit to the available capital
        }
        return w;
    }
}