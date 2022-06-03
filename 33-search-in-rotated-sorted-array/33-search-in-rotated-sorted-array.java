class Solution {
    public int search(int[] arr, int tar) {
        int lo = 0;
         int hi = arr.length -1;
        
        while(lo <= hi){
            int mid = (lo + hi)/2;
            
            if(arr[mid ] == tar){
                return mid;
            }else if(arr[lo] <= arr[mid]){
                if(tar >= arr[lo] && tar < arr[mid]){
                    hi = mid -1;
                }else{
                    lo = mid  + 1;
                }
            }else if(arr[mid] <= arr[hi]){
                if(tar > arr[mid] && tar <= arr[hi]){
                    lo = mid + 1;
                }else{
                    hi = mid -1;
                }
            } 
        }
        return -1;
    }
}