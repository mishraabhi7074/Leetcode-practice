// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class Solution
{
   //Function to evaluate a postfix expression.
   public static int evaluatePostFix(String S)
   {
       // Your code here
     
     Stack<Integer> st  = new Stack<>();
     
     
     for(int i= 0 ; i < S.length();i++){
         char ch = S.charAt(i);
         if(ch >='0' && ch <= '9'){
             st.push(Character.getNumericValue(ch));
         }else{
             int p = st.pop();
             int q = st.pop();
             int sum = 0 ;
             if(ch =='+'){
                 sum = p + q ;
                 
             }else if(ch == '-'){
                 sum = q-p;
             }else if (ch == '*'){
                  sum = p * q ;
                 
             }else if (ch == '/'){
                  sum = q / p;
             }
              st.push(sum);
         }
     }
     return st.pop();
   }
}