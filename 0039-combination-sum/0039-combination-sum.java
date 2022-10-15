class Solution {
     private int combinationSum(int[] arr, int tar, int idx, List<List<Integer>> ans, List<Integer> smallAns) {
        if (tar == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            ans.add(base);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                smallAns.add(arr[i]);
                count += combinationSum(arr, tar - arr[i], i, ans, smallAns);
                smallAns.remove(smallAns.size() - 1);
            }
        }
        return count;
    }

    public List<List<Integer>> combinationSum(int[] arr, int tar) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        combinationSum(arr, tar, 0, ans, smallAns);
        return ans;
    }
}