/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    List<int> view;
    int level = 0;
    public IList<int> RightSideView(TreeNode root) {
        view = new List<int>();
        TraverseTree(root, 1);
        return view;
    }
    private void TraverseTree(TreeNode root, int currentLevel)
    {
        if(root==null)
            return;
        if(currentLevel>level)
        {
            level = currentLevel;
            view.Add(root.val);
        }
        TraverseTree(root.right, currentLevel+1);
        TraverseTree(root.left, currentLevel+1);
    }
}