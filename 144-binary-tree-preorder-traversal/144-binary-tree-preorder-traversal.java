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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }      
        
        List<Integer> ans = new ArrayList<>();
        
        ans.add(root.val);
        List<Integer> l1 = preorderTraversal(root.left);
        List<Integer> l2 =preorderTraversal(root.right);
         
        ans.addAll(l1);
        ans.addAll(l2);
        
        return ans;
    }
}