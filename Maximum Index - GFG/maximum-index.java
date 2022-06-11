// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}// } Driver Code Ends


class Solution {

    int maxIndexDiff(int arr[], int n) {
       // code here
      int diff=0,maxdiff=0;
      
      for(int i=0;i<n/2;i++){
          for(int j=n-1;j>=i;j--){
              if(arr[i]<=arr[j])
              {
                  diff=j-i;
                  if(diff>maxdiff)
                  maxdiff=diff;
                  break;
              }
              
          }
      }
      return maxdiff;
   }
}