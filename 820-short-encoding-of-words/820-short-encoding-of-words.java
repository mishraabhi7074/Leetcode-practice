class Solution {
Set<String> set=new HashSet<String>();
public void action(String st)
{
    if(set.contains(st))
        set.remove(st);
}
public int minimumLengthEncoding(String[] words) {
    String shor="";
    for(int i=0;i<words.length; i++)
    {
        set.add(words[i]);
       }
      for(int i=0;i<words.length; i++)
     {
          String str=words[i];
          int n=str.length();
          if(!set.contains(str))
              continue;
         for(int j=1;j<n;j++) 
         {
             action(str.substring(j,n));
         }
     }
    int sum=0;
    for(String ch:set)
    {
        sum+=ch.length();
    }
    return sum+set.size();
}
}