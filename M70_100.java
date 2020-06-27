class Solution {
    public int climbStairs(int n) {
        int[] ans = new int[3];
        ans[0] = 0;ans[1] =1; ans[2] = 2;
        if(n<=2)
            return ans[n];
        
        for(int i = 2;i<n;i++)
        {
            ans[0] = ans[1];
            ans[1] = ans[2];
            ans[2] = ans[1] + ans[0];   
        }
        return ans[2];
    }
}