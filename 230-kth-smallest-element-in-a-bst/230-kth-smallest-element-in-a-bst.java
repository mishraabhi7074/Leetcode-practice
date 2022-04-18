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
    public int solve(TreeNode root, int k, List<Integer> list) {
        if(root == null) return 0;
        
        solve(root.left, k, list);
        
        list.add(root.val);
        
        if(list.size() >= k) {
            return list.get(k - 1);
        }
        
        return solve(root.right, k, list);
        
        
    }
    public int kthSmallest(TreeNode root, int k) {
        return solve(root, k, new ArrayList<>());
    }
}