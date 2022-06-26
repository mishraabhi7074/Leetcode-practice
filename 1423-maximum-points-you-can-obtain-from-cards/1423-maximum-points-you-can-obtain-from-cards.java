class Solution {
    public int maxScore(int[] array, int k) {
        int ans = 0;
        for(int i=1;i<array.length;i++) {
            array[i] = array[i] + array[i-1];
        }

        int sum = 0, len = array.length-1;
        if(len - k >= 0) ans = array[len] - array[len - k];
        for(int i=0;i<k && i<=len ;i++) {
            sum = array[len] - array[len-k+i+1] + array[i];
            ans = sum > ans ? sum : ans;
        }
        return ans;
    }
}