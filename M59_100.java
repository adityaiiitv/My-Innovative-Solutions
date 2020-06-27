class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if(n==0)
        {
            return result;
        }
        int left = 0, right = n-1, top = 0, bottom = n-1, count = 1, total = n*n;
        while(count<=total)
        {
            for(int i=left;i<=right;i++)
            {
                result[top][i] = count++;
            }
            top++;
            for(int i=top;i<=bottom;i++)
            {
                result[i][right] = count++;
            }
            right--;
            if(top<=bottom)
            {
                for(int i=right;i>=left;i--)
                {
                    result[bottom][i] = count++;
                }        
            }
            bottom--;
            if(right>=left)
            {
                for(int i=bottom;i>=top;i--)
                {
                    result[i][left] = count++;
                }
            }
            left++;
        }
        return result;
    }
}