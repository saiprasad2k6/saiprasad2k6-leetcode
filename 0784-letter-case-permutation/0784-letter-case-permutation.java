class Solution {
    public List<String> letterCasePermutation(String s) {
        if (s == null) return null;
        List<String> resultList = new ArrayList<>();
        findPermutation(s, 0, resultList, new StringBuilder(s));
        return resultList;
    }

    private void findPermutation(String s, int index, List<String> resultList, StringBuilder temp) {
        //Base case
        if (index == s.length()) {
            resultList.add(temp.toString());
            return;
        }
        Character c = s.charAt(index);
        if (Character.isAlphabetic(c)) {
            //Change to UpperCase and call the next
            temp.setCharAt(index, Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
            findPermutation(s, index + 1, resultList, temp);
            //Change back to Lower case and call the next
            temp.setCharAt(index, c);
        }
        findPermutation(s, index + 1, resultList, temp);
    }
}