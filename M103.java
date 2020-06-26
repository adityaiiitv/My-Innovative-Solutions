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
    List<List<Integer>> result;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        result = new ArrayList<>();
        traverse(root, 0);
        return result;
    }
    private void traverse(TreeNode root, int level)
    {
        if(root==null)
        {
            return;
        }
        if(result.size()<=level)
        {
            result.add(new ArrayList<>());
        }
        List<Integer> li = result.get(level);
        if(level%2==0)
        {
            li.add(root.val);
        }
        else{
            li.add(0, root.val);
        }
        traverse(root.left,level+1);
        traverse(root.right,level+1);
    }
}