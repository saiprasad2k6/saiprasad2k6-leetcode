class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();

        //findCombinations(1, n, k, new ArrayList<Integer>(), resultList);
        findCombinations(n, k, 1, new ArrayList<>(), resultList);


        return resultList;
    }

    private void findCombinations(int n, int k, int index, List<Integer> temp, List<List<Integer>> resultList) {
        //Base Case
        if (temp.size() == k) {
            resultList.add(new ArrayList<>(temp));

            return;
        }
        
        for (int i = index; i <= n; i++) {
            temp.add(i);
            findCombinations(n, k, i + 1, temp, resultList);
            temp.remove(temp.size() - 1);
        }
    }
}
