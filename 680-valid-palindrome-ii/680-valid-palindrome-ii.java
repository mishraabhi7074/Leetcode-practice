class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end))
                return (checkPalindrome(s,start,end-1) || checkPalindrome(s,start+1,end));
            start++;
            end--;
        }
        return true;
    }
    private boolean checkPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
}