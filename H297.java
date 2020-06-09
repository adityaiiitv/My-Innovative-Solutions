/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public static final String NullVal = "X";
    public static final String Split = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode root, StringBuilder sb)
    {
        if(root==null)
        {
            sb.append(NullVal); sb.append(Split); 
            return;
        }
        else{
            sb.append(root.val); sb.append(Split);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return buildTree(q);
    }
    
    private TreeNode buildTree(Queue<String> q)
    {
        String s = q.poll();
        if(s.equals(NullVal))
        {
            return null;
        }
        TreeNode t = new TreeNode(Integer.parseInt(s));
        t.left = buildTree(q);
        t.right = buildTree(q);
        return t;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));