/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<TreeNode>();
        LeftIterator(root);
        foreach(TreeNode t in st)
        {
            Console.WriteLine(t.val);
        }
    }
    
    private void LeftIterator(TreeNode root)
    {
        if(root==null) return;
        st.Push(root);
        LeftIterator(root.left);
    }
    
    
    /** @return the next smallest number */
    public int Next() {
        TreeNode temp = st.Pop();
        LeftIterator(temp.right);
        return temp.val;            
    }
    
    /** @return whether we have a next smallest number */
    public bool HasNext() {
        return st.Any();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.Next();
 * bool param_2 = obj.HasNext();
 */