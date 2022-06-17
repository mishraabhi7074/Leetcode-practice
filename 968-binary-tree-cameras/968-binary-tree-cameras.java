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
/*  if node have camera -> return 0;
    if node need camera -> return -1;
    if node is covered -> return 1;
    
    and we will go in postOrder
*/
class Solution {
    int cameras = 0;
    
    int solve(TreeNode root){      // postorder traversal
        if(root == null)   
            return 1;   //no need of camera node is covered
        
        int left = solve(root.left);
        int right = solve(root.right);
        
        if(left == -1 || right == -1){   //then we have to give a camera
            cameras++;
            return 0;        // current node have camera
        }
        else if(left == 0 || right == 0)
            return 1;      // already covered by children
        else              //childrens are covered and non of the children have camera. so to cover current node its parent will handle
            return -1;     //current node need camera
        
    }
    
    public int minCameraCover(TreeNode root) {
        if(solve(root) == -1)   // if root need camera
            cameras++;
        
        return cameras;
    }
}