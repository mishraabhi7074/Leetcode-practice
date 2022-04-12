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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        
        if (root.left == null && root.right == null) {
            return root;
        }
        
        // Swapping the left and right nodes using temp variable
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
		// Repeat the same for left and right using recursion
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}