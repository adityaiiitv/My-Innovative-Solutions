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
    public boolean isValidBST(TreeNode root) {
        return isNodeWithinLimits(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isNodeWithinLimits(TreeNode root, long left, long right)
    {
        if(root==null)
        {
            return true;
        }
        return root.val<right && root.val>left &&
            isNodeWithinLimits(root.left, left, root.val) && isNodeWithinLimits(root.right, root.val, right);
    }
}