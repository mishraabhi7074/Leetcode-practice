class Solution {
    public int pivotIndex(int[] arr) {
        int sum =0;
        
        for(int i =0; i < arr.length; i++){
            sum += arr[i];
        }
        
        int lsum =0;
        int rsum = sum;
        
        for(int i = 0; i < arr.length; i++){
            rsum = rsum - arr[i];
            
            if(lsum == rsum){
                return i;
            }
            lsum += arr[i];
        }
        return -1;
    }
}