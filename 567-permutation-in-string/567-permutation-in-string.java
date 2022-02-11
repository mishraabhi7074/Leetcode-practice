class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1=s1.length() , n2=s2.length();
        boolean res=false;
        if(n1>n2) return res;
        
        HashMap<Character,Integer> map=new HashMap<>();
        
        for(int i=0;i<n1;i++)
        {
            char ch=s1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count=map.size();
        
        // sliding window having window size equal to s1 string's length
        int i=0,j=0;
        while(j<n2)
        {
            //calculation
            char ch=s2.charAt(j);
            if(map.containsKey(ch))
            {
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) == 0) //if freq becomes zero then decrement count
                    count--;
            }
            if(j-i+1 < n1) // increase window size
                j++;
            else if(j-i+1 == n1)
            {
                if(count==0)
                {
                    res=true;
                    return res;
                }
                else
                {
                    char ch2=s2.charAt(i);
                    if(map.containsKey(ch2))
                    {
                        map.put(ch2,map.get(ch2)+1);
                        if(map.get(ch2)==1) // when Freq --- 0 -> 1 then only increase count
                            count++;
                    }
                }
                i++; //slide the window
                j++;
            }         
        }
        return res;
    }
}