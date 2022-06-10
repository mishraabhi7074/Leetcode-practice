class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int max = 0;
        int maxRepeatChar = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
            // Get Window having maximum repeating Character
            maxRepeatChar = Math.max(maxRepeatChar, freqMap.get(c));
            //check if the remaining chars in maxrepeating window are greater than k, if yes - shrink the window 
            if(right -left +1 - maxRepeatChar >k){
                char leftchar = s.charAt(left);
                freqMap.put(leftchar, freqMap.get(leftchar)-1);
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}