class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Map<Character, Integer> hashMap = new HashMap<>();

        for (j = 0; j < s.length(); j++) {
            hashMap.put(s.charAt(j), hashMap.getOrDefault(s.charAt(j), 0) + 1);
            int windowSize = j - i + 1;
            if (hashMap.size() == windowSize) {
                max = Math.max(max, windowSize);
                continue;
            }

            while (hashMap.size() < (j - i + 1)) {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) - 1);
                if (hashMap.get(s.charAt(i)) == 0) hashMap.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}