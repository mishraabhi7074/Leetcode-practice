class Solution {
    public int removePalindromeSub(String s) {
        int count =1;
        int j =s.length()-1;
        for(int i =0;i<s.length();i++){
            if(j>i){
            char ch0 = s.charAt(i);
            char chl = s.charAt(j);
                if(ch0!=chl){
                    count++;
                    break;
                }
              }
            j--;
       }
        return count;
    }
}