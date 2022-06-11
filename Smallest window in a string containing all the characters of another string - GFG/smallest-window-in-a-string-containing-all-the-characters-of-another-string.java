// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s1, String s2)
    {
        // Your code here
         if(s2.length() == 1){
            for(int i = 0 ; i < s1.length(); i++){
                if(s1.charAt(i) == s2.charAt(0)){
                    return s2;
                }
            }
            return "-1";
        }
        
        HashMap<Character,Integer> map1 = new HashMap<>();
	    HashMap<Character,Integer> map2 = new HashMap<>();
	    for(int i = 0 ; i < s2.length(); i++){
	        char ch = s2.charAt(i);
	        map2.put(ch,map2.getOrDefault(ch,0) + 1);
	    }
	    
	    int subSLength = Integer.MAX_VALUE;
	    int matchcount = 0;
	    int[] fans = new int[2];
	    for(int i = 0, j = 0; i < s1.length(); i++){
	        char c = s1.charAt(i);
	        if(map2.containsKey(c)){
	            map1.put(c,map1.getOrDefault(c,0) + 1);
	            if(map1.get(c) <= map2.get(c)){
	                matchcount++;
	            }
	            while(matchcount == s2.length()){
	                char chj = s1.charAt(j);
	                if(!map1.containsKey(chj)){
	                    //nothing
	                }else if(map1.get(chj) > map2.getOrDefault(chj,0)){
	                    map1.put(chj,map1.get(chj) - 1);
	                }else{
	                    if(i - j + 1 < subSLength){
	                        subSLength = i - j + 1;
	                        fans[0] = i;
	                        fans[1] = j;
	                    }
	                    map1.put(chj,map1.get(chj) - 1);
	                    if(map1.get(chj) < 0){
	                        map1.remove(chj);
	                    }
	                    matchcount--;
	                }
	                j++;
	            }
	           
	        }    
	        
	    }
	    if(fans[0] == fans[1] && s2.length() != 1){
	        return "-1";
	    }else
	    return (s1.substring(fans[1],fans[0] + 1));
    }
}