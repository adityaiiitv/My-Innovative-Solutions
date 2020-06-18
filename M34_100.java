class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = findElement(nums, target);
        if(index == -1)
        {
            return new int[]{-1,-1};
        }
        int low = findLower(nums,target,index);
        int high = findHigher(nums,target,index);
        return new int[]{low,high};
    }
    private int findLower(int[] nums, int target, int high)
    {
        int low = 0, mid;
        while(low<high)
        {
            mid = (low+high)/2;
            if(nums[mid]!=target && nums[mid+1]==target)
            {
                return mid+1;
            }
            if(nums[mid]==target)
            {
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    private int findHigher(int[] nums, int target, int low)
    {
        int high = nums.length-1, mid;
        while(low<high)
        {
            mid = (low+high)/2;
            if(nums[mid]==target && nums[mid+1]!=target)
            {
                return mid;
            }
            if(nums[mid]==target)
            {
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
    private int findElement(int[] nums, int target)
    {
        int low = 0, high = nums.length-1, mid;
        while(low<=high)
        {
            mid = (low+high)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            if(nums[mid]>target)
            {
                high=mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}