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
    Map<Integer, PriorityQueue<Integer>> map;
    int left, right;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap<>();
        left = 0; right = 0;
        iterateTree(root,0);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=left;i<=right;i++)
        {
            List<Integer> list = new ArrayList<>();
            while(!map.get(i).isEmpty())
            {
                list.add(map.get(i).poll());
            }
            result.add(list);
        }
        return result;
    }
    
    private void iterateTree(TreeNode root, int level)
    {
        if(root==null)
            return;
        if(level<left)
            left = level;
        if(level>right)
            right=level;
        if(!map.containsKey(level))
        {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(root.val);
            map.put(level, pq);
        }
        else{
            map.get(level).add(root.val);
        }
        iterateTree(root.right,level+1);
        iterateTree(root.left,level-1);
    }
}