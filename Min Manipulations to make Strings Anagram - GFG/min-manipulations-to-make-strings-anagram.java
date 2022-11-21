//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine().trim());
            String []input_line = read.readLine().trim().split("\\s+");
            String S1 = input_line[0];
            String S2 = input_line[1];
            Solution obj = new Solution();
            int ans = obj.minManipulation(N, S1, S2); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int minManipulation(int N, String S1, String S2) 
    {
        // code here
         // code here
        int[]f=new int[26];
        for(int i=0;i<N;i++){
            char ch=S1.charAt(i);
            f[ch-'a']++;
        }
        for(int i=0;i<N;i++){
            char ch=S2.charAt(i);
            f[ch-'a']--;
        }
        int ans=0;
        for(int i=0;i<26;i++){
            ans+=Math.abs(f[i]);
        }
        return ans>0?ans/2:ans;
    }
} 