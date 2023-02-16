class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[26];
        for (char x : s1.toCharArray()) {
            cnt[x - 'a']++;
        }

        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        for (int i = 0; i < m; i++) {
            cnt[s2.charAt(i) - 'a']--;
            if (i - n >= 0) {
                cnt[s2.charAt(i - n) - 'a']++;
            }

            if (zero(cnt)) {
                return true;
            }


        }
        return false;
    }

    private boolean zero(int[] arr) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}