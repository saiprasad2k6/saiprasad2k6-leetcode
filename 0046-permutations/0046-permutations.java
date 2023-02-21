class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        findPermute(nums, temp, resultList, new HashSet<Integer>());
        return resultList;
    }

    private void findPermute(int[] nums, List<Integer> temp, List<List<Integer>> resultList, Set<Integer> hSet) {
        //Base Case
        if (temp.size() == nums.length) {
            resultList.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (hSet.contains(nums[i])) continue;
            temp.add(nums[i]);
            hSet.add(nums[i]);
            findPermute(nums, temp, resultList, hSet);
            temp.remove(temp.size() - 1);
            hSet.remove(nums[i]);
        }
    }
}