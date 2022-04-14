/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p.val, q.val);
    }
    public TreeNode helper(TreeNode root, int p, int q){
        if(root == null) return null;
        if(root.val == p || root.val ==q)
            return root;
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if(left != null && right != null) return root;  //if both are null then root is LCA
        return left!=null ? left : right;
    }
}