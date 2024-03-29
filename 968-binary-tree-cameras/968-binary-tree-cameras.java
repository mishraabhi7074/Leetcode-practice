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
    
    int count = 0;
    final int CAMERA = 1;
    final int NOT_MONITORED = 2;
    final int MONITORED = 3;
    public int minCameraCover(TreeNode root) {
        int val = helper(root);
        
        if(val == NOT_MONITORED){
         count++;
     }
        return count;
        
    }
    
    public int helper(TreeNode node){
        if(node == null){
            return MONITORED;
        }
        
        int left = helper(node.left);
        int right = helper(node.right);
        
        if(left == NOT_MONITORED || right == NOT_MONITORED){
            count++;
            return CAMERA;
            
        }else if(left == CAMERA || right == CAMERA){
            return MONITORED;
        }else{
            return NOT_MONITORED;
        }
        
    }
}