class Solution {
    public int maxSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        if(arr.length==1){return arr[0];}
        for (int i = 0; i < arr.length; i++) {
            currSum = currSum + arr[i];
            if(currSum > maxSum){maxSum = currSum;}
            if(currSum < 0){currSum = 0;}
        }
        return maxSum;
    }
}