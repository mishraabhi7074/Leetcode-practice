/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


   
class Solution {
    class Pair implements Comparable<Pair>{
    TreeNode node;
    int w; // width
    int d; // depth
    
    Pair(TreeNode node, int w, int d){
        this.node = node;
        this.w =w;
        this.d =d;
    }
     // this - other means incresing
     // other - this means decresing
     public int compareTo(Pair other){
        if(this.d == other.d){
            return this.node.val - other.node.val;
        }else{
            return this.d - other.d;
        }
    }
}
    public List<List<Integer>> verticalTraversal(TreeNode root) {
       Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 1));
        
        int lmw = 0; // left most width
        int rmw = 0; // right most width
        
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
        while(q.size() > 0){
            
            Pair temp = q.remove();
            
            if(temp.w < lmw){
                lmw = temp.w;
            }
            
             if(temp.w > rmw){
                rmw = temp.w;
            }
            
            if(map.containsKey(temp.w) == false){
                map.put(temp.w, new ArrayList<>());
                map.get(temp.w).add(temp);
            }else{
                map.get(temp.w).add(temp);
            }
            
            if(temp.node.left != null){
                q.add(new Pair(temp.node.left, temp.w - 1, temp.d + 1));
            }

            if(temp.node.right != null){
                q.add(new Pair(temp.node.right, temp.w + 1, temp.d + 1));
            }
            
        }
        
         List<List<Integer>> res = new ArrayList<>();
        for(int w = lmw; w <= rmw; w++){
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Pair> unsortedList = map.get(w);
            Collections.sort(unsortedList);

            for(Pair temp: unsortedList){
                list.add(temp.node.val);
            }


            res.add(list);
        }
        
        return res;
    }
}














