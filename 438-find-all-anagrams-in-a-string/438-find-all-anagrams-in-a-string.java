class Solution {
    //do the dry run again
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> output = new ArrayList<>();
        
        // Basic check to see if the array is empty or not
        if(s.length() == 0 || s == null) return output;
        
        // This array will store the count of each and every alphabet
        // The size will be 26 as there are only 26 letters in alphabets
        int[] charCount = new int[26];
        
        for(char c : p.toCharArray()){
            // basically incrementing the assigned index for each alphabet 
            charCount[c - 'a']++;
        }
// After this loop we will have our frequencies of each alphabet in the charCount array
        
        int left = 0;
        int right = 0;
        int count = p.length();
        
        while(right < s.length()){
// this checks if the value present at the right index is atleast 1 as that would mean that the current alphabet is there in the p string , we all decrement the count of the alphabet after we found it and move the right pointer 1 step forward
            
            if(charCount[s.charAt(right++) - 'a']-- >= 1) count--;
            
            // if our count reaches 0 that means we fount the Anagram that we need and we just add the starting index of the anagram
            if(count == 0) output.add(left);
            
            // if we found the whole anagram and charcount at the left index is still greater than or equal to 0, then we move the left pointer forward and we increment the charcount back so it does not affect the approach in the next step
            if(right - left == p.length() && charCount[s.charAt(left++) - 'a']++ >= 0) count ++;
        }
        
        return output;
    }
}