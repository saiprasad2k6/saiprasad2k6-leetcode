class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int i = num.length - 1;
        int carry = 0, sum = 0;

        List<Integer> result = new ArrayList<>();

        while (i >= 0 || k > 0 || carry > 0) {
            sum = carry;
            if (i >= 0) sum += num[i--];
            if (k > 0) sum += k % 10;
            result.add(sum % 10);

            k /= 10;
            carry = sum / 10;
        }

        Collections.reverse(result);
        return result;
    }
}