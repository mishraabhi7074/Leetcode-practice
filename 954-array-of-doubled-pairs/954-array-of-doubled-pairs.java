class Solution {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val:arr){
            map.put(val, map.getOrDefault(val , 0) + 1);
        }
        
        Arrays.sort(arr);
        
        for(int val : arr){
            if(val == 0){
                continue;
            }
            
            if(map.containsKey(val) && map.containsKey(2*val)){
                if(map.getOrDefault(val, 0) > 1){
                    map.put(val, map.getOrDefault(val, 0) - 1);
                }else{
                    map.remove(val);
                }
                
                if(map.getOrDefault(2*val, 0) > 1){
                    map.put(2*val, map.getOrDefault(2*val, 0) -1);
                }else{
                    map.remove(2*val);
                }
            }
        }
        
        if(map.size() == 0){
            return true;
        }else if(map.size() == 1 && map.containsKey(0)){
            return true;
        }else{
            return false;
        }
    }
}