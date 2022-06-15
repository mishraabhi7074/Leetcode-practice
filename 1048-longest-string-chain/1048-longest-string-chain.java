class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] dp = new int[words.length];
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            int n = words[i].length();
            List<Integer> list = map.getOrDefault(n - 1, new ArrayList<>());
            int max = 0;
            for (int idx : list) {
                if (check(words[idx], words[i])) {
                    max = Math.max(max, dp[idx]);
                }
            }
            List<Integer> cur = map.get(n);
            if (cur == null) {
                cur = new ArrayList<>();
                map.put(n, cur);
            }
            cur.add(i);
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        } 
        return ans;
    }
    
    boolean check(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m + 1 != n)
            return false;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (word1.charAt(i) == word2.charAt(j))
                i++;
            j++;
        }
        return i + 1 == n;
    }
}