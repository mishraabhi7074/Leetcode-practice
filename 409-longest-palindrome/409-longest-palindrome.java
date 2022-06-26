//revise again
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> hSet = new HashSet<>();
        int resultCount = 0;
        int length = s.length();
        int containsOdd = 0;
        
        for(int i = 0; i < length; i++){
            if(!hSet.contains(s.charAt(i))){
                hSet.add(s.charAt(i));
                containsOdd++;
            }
            else{
                resultCount = resultCount + 2;
                hSet.remove(s.charAt(i));
                containsOdd--;
            }
        }
        
        if(containsOdd > 0)
            resultCount++;
        
        return resultCount;
    }
}