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
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        traverse(root, 1);
        return maxDepth;
    }
    public void traverse(TreeNode root, int level)
    {
        if(root==null)
        {
            maxDepth = Math.max(level-1, maxDepth);
            return;
        }
        traverse(root.left, level+1);
        traverse(root.right, level+1);
    }
}