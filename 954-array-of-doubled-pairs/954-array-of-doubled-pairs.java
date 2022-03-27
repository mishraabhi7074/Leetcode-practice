class Solution {
    public boolean canReorderDoubled(int[] arr) {
        if(arr.length == 0){
            return true;
        }
        
        HashMap<Integer, Integer> freqmap = new HashMap<>();
        
        for(int ele:arr){
            freqmap.put(ele, freqmap.getOrDefault(ele, 0) + 1);
        }
        
        Integer []ar = new Integer[arr.length];
        
        for(int i =0; i < arr.length; i++){
            ar[i] = arr[i];
        }
        
        Arrays.sort(ar, (a, b)->{
            return Math.abs(a) - Math.abs(b);
        });
        
        for(Integer ele: ar){
            if(freqmap.get(ele) == 0){
                continue;
            }
            if(freqmap.getOrDefault(2*ele, 0) == 0){
                return false;
            }
            freqmap.put(ele, freqmap.get(ele) -1);
            freqmap.put(2*ele, freqmap.get(2*ele) -1);
        }
        return true;
    }
}