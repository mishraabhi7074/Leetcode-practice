//do it again
class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[27];
        HashSet<Integer> hs = new HashSet<>();
        for(Character c:s.toCharArray())
        {
            freq[c-'a']++;
        }
        int count = 0;
        for(int i=0;i<26;i++)
        {
            int curr_freq = freq[i];
            if(curr_freq != 0)
            {
                if(hs.contains(curr_freq))
                {
                    while(hs.contains(curr_freq) && curr_freq>0)
                    {
                        curr_freq--;
                        count++;
                    }
                    if(curr_freq!=0)
                        hs.add(curr_freq);
                }
                else
                    hs.add(curr_freq);
            }
        }
        return count;
    }
}