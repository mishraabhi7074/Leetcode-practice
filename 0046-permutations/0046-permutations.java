class Solution {
     public int permute(int[] nums, int ElementUsed, List<List<Integer>> ans, List<Integer> smallAns) {
        if (ElementUsed == nums.length) {
            List<Integer> base = new ArrayList<>(smallAns);
            ans.add(base);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > -11) {
                int val = nums[i];
                nums[i] = -11; // used
                smallAns.add(val);

                count += permute(nums, ElementUsed + 1, ans, smallAns);

                nums[i] = val; // unused
                smallAns.remove(smallAns.size() - 1);
            }
        }
        return count;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        permute(nums, 0, ans, smallAns);
        return ans;
    }
}