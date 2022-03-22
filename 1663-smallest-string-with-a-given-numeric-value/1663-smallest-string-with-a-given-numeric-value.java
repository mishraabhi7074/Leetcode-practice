class Solution {
    public String getSmallestString(int n, int k) {
        char []chs = new char[n];
        for(int i=n-1; i>=0; i--){
            if(k - i <= 26){
                chs[i] =(char)( (k-i - 1) + 'a') ;
                k = i;
            }
            else{
                chs[i] = 'z';
                k-=26;
            }
        }
        return String.valueOf(chs);
    }
}