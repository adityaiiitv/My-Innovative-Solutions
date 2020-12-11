class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int productYet = 1;
        for(int i=0;i<nums.length;i++)
        {
            result[i] = productYet;
            productYet*=nums[i];
        }
        productYet = 1;
        for(int i=nums.length-1;i>=0;i--)
        {
            result[i] *= productYet;
            productYet*=nums[i];
        }
        return result;
    }
}