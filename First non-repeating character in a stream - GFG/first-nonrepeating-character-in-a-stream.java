// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        // approch understanded but code not done
       StringBuilder sb  = new StringBuilder();
       Queue<Character>q = new LinkedList<>();
       Map<Character,Integer>map = new HashMap<>();
       for(int i=0;i<A.length();i++)
       {
           //making freq map
           char ch = A.charAt(i);
           map.put(ch,map.getOrDefault(ch,0)+1);
           
           q.add(ch); // adding char to queue
           while(!q.isEmpty()){
               if(map.containsKey(q.peek()) && map.get(q.peek())>1){
                   q.poll();
               }else{
                   break;
               }
           }
           if(q.isEmpty()){
               sb.append('#');
           }else{
               sb.append(q.peek());
           }
       }
       return sb.toString();
    }
}