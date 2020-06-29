class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        addSubsets(nums, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void addSubsets(int[] nums, List<Integer> set, int pos)
    {
        result.add(new ArrayList<>(set));
        for(int i=pos;i<nums.length;i++)
        {
            set.add(nums[i]);
            addSubsets(nums, set, i+1);
            set.remove(set.size()-1);
        }
    }
}