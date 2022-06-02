class Solution {
    public int[] productExceptSelf(int[] arr) {
        
        // right side product array
        int [] right = new int[arr.length];
        int prd = 1;
        for(int i = arr.length-1; i >=0; i--){
            prd *= arr[i];
            right[i] = prd;
        }
        
        // result and left side product array
        prd =1;
        int [] res = new int[arr.length];
        for(int i =0; i < arr.length -1; i++){
            int lp = prd;
            int rp = right[i+1];
            res[i] = lp * rp;
            prd *= arr[i];
            
        }
        res[arr.length -1] = prd;
        return res;
        
    }
}