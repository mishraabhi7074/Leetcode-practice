class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String ans = strs[0];
        for(String s : strs){
            int i =0;
            while(i < Math.min(ans.length(), s.length()) && ans.charAt(i) == s.charAt(i)){
                i++;
            }
            ans = s.substring(0, i);
        }
        return ans;
    }
}