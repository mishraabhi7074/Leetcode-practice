class Solution {
    public String minRemoveToMakeValid(String s) {
        

        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        
        for(int i = 0 ; i< s.length() ; i++){
            
            char c = s.charAt(i);
            
            if(c == '('){
                
                start += 1;   // increment the start variable if '('
                sb.append(c);
            }
            
            else if(c == ')'){
                
                if(start == 0){ // If there is no corresponding previous opening bracket 
                    
                }
                else{  // If there is a corresponding previous opening bracket 
                    sb.append(c);
                    start -= 1;
                }
            }
            else{
                sb.append(c);
            }
        }
        
        start = 0;
        end = 0;
        
        s = sb.toString();
        sb = new StringBuilder();
        // System.out.println("S1 "+ s);
        
        for(int i = s.length()-1 ; i >= 0 ; i--){
            
            char c = s.charAt(i);
            
            if(c == ')'){ //Increment the end pointer
                
                end += 1;
                sb.append(c);
            }
            
            else if(c == '('){
                
                if(end == 0){  // If there is no corresponding previous closing bracket 
                    
                }
                else{  // If there is a corresponding previous closing bracket 
                    sb.append(c);
                    end -= 1;
                }
            }
            else
                sb.append(c);
        }
        
        s = sb.reverse().toString();  // Reverse the string to get the valid output
        
        // System.out.println("S2 "+ s);
        return s;
    }
}