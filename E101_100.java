/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || symmetryHelper(root.left, root.right);
    }
    
    private boolean symmetryHelper(TreeNode leftNode, TreeNode rightNode)
    {
        if(leftNode==null || rightNode==null)
        {
            return leftNode==rightNode;
        }
        if(leftNode.val!=rightNode.val)
        {
            return false;
        }
        return symmetryHelper(leftNode.left, rightNode.right) && symmetryHelper(leftNode.right, rightNode.left);
    }
}