class Solution {
    public List<Integer> partitionLabels(String s) {
        int[]arr= new int[26];
        List <Integer> list = new ArrayList<Integer>();
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']=i;
        }
        int start = 0; int i=0; int end=0;int count=0;
        int last= arr[s.charAt(i)-'a'];
        while(true){
            
            while(i!=last){
                if(arr[s.charAt(i)-'a']>last) last = arr[s.charAt(i)-'a'];
                count++;i++;
            }
            list.add(count+1);count=0;
            if(last+1<s.length()){
                i=last+1;
                last= arr[s.charAt(i)-'a'];
            }else{
                break;
            }
        }
        return list;
    }
}