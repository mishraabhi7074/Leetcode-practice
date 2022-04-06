class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        try{
            String[] arr=ransomNote.split("");
            int idx=0;
            
            for(int i=0;i<arr.length;i++){
                //check existence
                idx=magazine.indexOf(arr[i]);
                
                if(idx>=0){
                    //remove
                    magazine=magazine.replaceFirst(arr[i],"");
                }
                else{
                    return false;
                }
            }
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
}