class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int answer = 0;

        int start = 0;
        int end = people.length - 1;
        Arrays.sort(people);

        while (start <= end) {
            int sum = people[start] + people[end];
            answer++;
            if (sum <= limit) {
                start++;
                end--;
            } else {
                end--;
            }
        }
        return answer;

    }
}