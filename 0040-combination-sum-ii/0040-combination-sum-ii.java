class Solution {
   private int combinationSum2(int[] arr, int tar, int idx, List<List<Integer>> ans, List<Integer> smallAns) {
        if (tar == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            ans.add(base);
            return 1;
        }

        int count = 0, prev = -1;
        for (int i = idx; i < arr.length; i++) {
            if (prev != arr[i] && tar - arr[i] >= 0) {
                smallAns.add(arr[i]);
                count += combinationSum2(arr, tar - arr[i], i + 1, ans, smallAns);
                smallAns.remove(smallAns.size() - 1);
                prev = arr[i];
            }
        }
        return count;
    }

    public List<List<Integer>> combinationSum2(int[] arr, int tar) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        combinationSum2(arr, tar, 0, ans, smallAns);
        return ans;
    }
}