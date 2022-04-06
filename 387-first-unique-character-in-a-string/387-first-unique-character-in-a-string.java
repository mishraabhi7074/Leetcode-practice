class Solution {
    public int firstUniqChar(String s) {
        int ret  =  s.length()-1;
        int l =0,r=1;
        HashSet<Character> hs  =new HashSet<Character>(); 
        while(l < s.length() && r < s.length())
        {
            if(s.charAt(l) == s.charAt(r))
            {
                hs.add(s.charAt(l));
                l++;
                r = l+1;
                ret = -1;     
            }
            else
            {
                if(!hs.contains(s.charAt(l)))
                {
                    r++;
                    ret = l;
                 }
                else
                {
                    l++;
                    if(l == s.length()-1 && !hs.contains(s.charAt(l)))
                    {
                       return l;
                    }
                    r = l+1;
                    ret = -1;
                }
            }  
        }
        return ret; 
    }
}