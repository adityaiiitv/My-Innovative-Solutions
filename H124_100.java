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
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        traverseAndUpdateMax(root);
        return max;
    }
    
    private int traverseAndUpdateMax(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int left = Math.max(0,traverseAndUpdateMax(root.left));
        int right = Math.max(0,traverseAndUpdateMax(root.right));
        if(left+right+root.val > max)
        {
            max = left+right+root.val;
        }
        return Math.max(left,right)+root.val;
    }
}