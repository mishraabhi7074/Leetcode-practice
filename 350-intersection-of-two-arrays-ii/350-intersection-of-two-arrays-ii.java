class Solution {
public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
    List<Integer> ab = new ArrayList<Integer>();
    for(int a :nums1)
        hs.put(a,hs.getOrDefault(a,0)+1);
    for(int b : nums2)
    {
        if(hs.get(b) !=null && hs.get(b) > 0)
        {
            hs.put(b,hs.get(b)-1);
            ab.add(b);
        }
    }
    int[] arr = new int[ab.size()];
    int i = 0;
    for(int x: ab)
    {
        arr[i++] = x;
    }
    return arr;
        
  }  
}