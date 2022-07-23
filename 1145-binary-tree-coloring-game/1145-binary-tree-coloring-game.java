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
    
    int xkaleft;
    int xkaright;
    
    public int size(TreeNode node, int x){
        if(node == null) return 0;
        
        int ls = size(node.left, x);
        int rs = size(node.right, x);
        
        
        if(node.val == x){
            xkaleft = ls;
            xkaright = rs;
        }
        
        int ts = ls + rs + 1;
        return ts;
        
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        size(root, x);
        
        int player2size = n - (xkaleft + xkaright + 1);
        int maxofthree = Math.max(player2size,Math.max(xkaleft, xkaright));
        int player1size = n - maxofthree;
        
        if(maxofthree > player1size) return true;
        else return false;
    }
}