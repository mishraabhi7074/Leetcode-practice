class Solution {
    public int maxProduct(int[] arr) {
        int ans = Integer.MIN_VALUE;
        int cprd =1;
        for( int i =0; i < arr.length; i++){
            cprd *= arr[i];
            ans = Math.max(ans, cprd);
            if(cprd == 0){
                cprd =1;
            }
        }
        cprd =1;
        for(int i = arr.length -1; i >=0; i--){
             cprd *= arr[i];
            ans = Math.max(ans, cprd);
            if(cprd == 0){
                cprd =1;
            }
        }
        return ans;
    }
    
}