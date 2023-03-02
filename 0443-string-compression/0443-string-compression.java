class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if (n == 1) {
            return 1;
        }
        int i = 0, j = 0;

        while (i < n) {
            int count = 1;
            //Navigate until the characters are same
            while (i < (n - 1) && (chars[i] == chars[i + 1])) {
                count++;
                i++;
            }
            //Jump to the next character
            chars[j++] = chars[i++];
            
            //Add the Count
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray())
                    chars[j++] = c;
            }
            
        }
        return j;

    }
}