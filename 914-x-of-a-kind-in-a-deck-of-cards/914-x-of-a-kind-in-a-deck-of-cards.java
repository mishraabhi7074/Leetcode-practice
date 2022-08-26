class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val: deck){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int count = 0;
        int gcd =1;
        
        for(int key:map.keySet()){
            if(count == 0){
                gcd = map.get(key);
            }else{
                int num = map.get(key);
                gcd = getGCD(num , gcd);
            }
            count++;
        }
        return gcd >= 2;
    }
    
    public int getGCD(int n1, int n2){
        while(n1 % n2 != 0){
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        return n2;
    }
}