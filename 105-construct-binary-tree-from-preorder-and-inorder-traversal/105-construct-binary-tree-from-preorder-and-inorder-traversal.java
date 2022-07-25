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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < inorder.length; i++){
            int val = inorder[i];
            map.put(val, i);
        }
        TreeNode root = construct(0, preorder.length -1, 0, inorder.length -1, preorder, map);
        return root;
    }
    
    public TreeNode construct(int prelo, int prehi, int inlo, int inhi, int[]pre, HashMap<Integer, Integer> map){
        if(prelo > prehi || inlo > inhi){
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = pre[prelo];
        int index = map.getOrDefault(pre[prelo], 0);
        int lhs = index - inlo;
        
        node.left = construct(prelo + 1, prelo + lhs, inlo, index -1, pre, map);
        node.right = construct(prelo + lhs +1, prehi, index + 1, inhi, pre, map);
        
        return node;
        
    }
}