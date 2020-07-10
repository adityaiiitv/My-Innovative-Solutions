class Solution {
    public void sortColors(int[] nums) {
        int start=0, end=nums.length-1, temp;
        for(int i=start;i<=end;)
        {
            if(nums[i]==0)
            {
                temp = nums[i];
                nums[i++] = nums[start];
                nums[start++] = temp;
            }
            else if(nums[i]==2)
            {
                temp = nums[i];
                nums[i] = nums[end];
                nums[end--] = temp;
            }
            else{
                i++;
            }
        }
    }
}