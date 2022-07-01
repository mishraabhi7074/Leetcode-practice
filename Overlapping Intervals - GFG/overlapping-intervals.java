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
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here 
        Arrays.sort(Intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
       
       List<int[]> res = new ArrayList<>();
       int[] current_interval = Intervals[0];
       res.add(current_interval);
       
       for(int[] interval: Intervals){
           int current_begin = current_interval[0];
           int current_end = current_interval[1];
           
           int next_begin = interval[0];
           int next_end = interval[1];
           
           if(next_begin <= current_end){
               current_interval[1] = Math.max(current_end, next_end);
           }
           else{
               current_interval = interval;
               res.add(current_interval);
           }
       }
       return res.toArray(new int[res.size()][]);
    }
}