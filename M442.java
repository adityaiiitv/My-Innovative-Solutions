class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[Math.abs(nums[i])-1]<0)
            {
                set.add(Math.abs(nums[i]));
            }
            nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
        }
        return new ArrayList<Integer>(set);
    }
}