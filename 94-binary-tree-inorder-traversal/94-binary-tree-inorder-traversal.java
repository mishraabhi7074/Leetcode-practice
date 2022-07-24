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
    public List<Integer> inorderTraversal(TreeNode root) {
        //by morris traversal
        ArrayList<Integer> retval = new ArrayList<>();
        
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                //add the node to the arraylist
                //move to the right child
                retval.add(curr.val);
                curr = curr.right;
            }else{
                
                TreeNode iop = curr.left; // iop -> in order predessor
                while(iop.right != null && iop.right != curr){
                    iop = iop.right;
                }
                
                if(iop.right == null){
                    iop.right = curr;
                    curr = curr.left;
                }else{
                    iop.right = null;
                    retval.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return retval;
    }
}