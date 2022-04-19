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
    public void recoverTree(TreeNode root) {
		List<Integer> values = new ArrayList<Integer>();
		helper(root, values);
		values.sort(Comparator.naturalOrder());
		swap(root, values);
	}

	private void swap(TreeNode root, List<Integer> values) {
		if (root == null)
			return;

		swap(root.left, values);
		root.val = values.get(0);
		values.remove(0);
		swap(root.right, values);
	}

	private void helper(TreeNode root, List<Integer> values) {
		if (root == null)
			return;

		helper(root.left, values);
		values.add(root.val);
		helper(root.right, values);
	}
}