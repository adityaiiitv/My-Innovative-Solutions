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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        iterateTree(root, result);
        return result;
    }
    
    private int iterateTree(TreeNode root, List<List<Integer>> res)
    {
        if(root==null)
        {
            return -1;
        }
        int height = Math.max(iterateTree(root.left, res), iterateTree(root.right, res)) + 1;
        if(height>=res.size()) 
        {
            res.add(new ArrayList<Integer>());
        }
        res.get(height).add(root.val);
        return height;
    }
    
}