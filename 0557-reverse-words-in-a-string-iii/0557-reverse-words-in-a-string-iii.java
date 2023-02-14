class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = reverse(words[i]);
        }

        return String.join(" ",words);
    }

    private String reverse(String word) {
        char[] wordChar = word.toCharArray();
        int i = 0;
        int j = wordChar.length - 1;

        while (i < j) {
            char temp = wordChar[i];
            wordChar[i] = wordChar[j];
            wordChar[j] = temp;

            i++;
            j--;
        }

        return new String(wordChar);
    }
}