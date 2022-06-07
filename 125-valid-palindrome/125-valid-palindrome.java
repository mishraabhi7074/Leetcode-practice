class Solution {
    public boolean isPalindrome(String s) {
        String res = "";

    for (char c:s.toCharArray()){
        if (Character.isDigit(c) || Character.isLetter(c)){
            res += c;
        }
    }
    res = res.toLowerCase();
    
    int start = 0, end = res.length()-1;
    
    while(start<=end){
        if (res.charAt(start)!=res.charAt(end)){
           return false;
        }
        start++;
        end--;
    }
    return true;
    }
}