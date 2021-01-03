class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(dict.containsKey(target-nums[i]))
            {
                return new int[]{dict.get(target-nums[i]),i};
            }
            if(!dict.containsKey(nums[i]))
            {
                dict.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}