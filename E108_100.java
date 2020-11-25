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
    private int[] arr;
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
        {
            return null;
        }
        arr = nums;
        return helper(0, arr.length-1);
    }
    
    private TreeNode helper(int low, int high)
    {
        if(low>high)
        {
            return null;
        }
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = helper(low, mid-1);
        root.right = helper(mid+1, high);
        return root;
    }
}