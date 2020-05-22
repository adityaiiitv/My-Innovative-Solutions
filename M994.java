class Solution {
    public int orangesRotting(int[][] grid) {
        boolean rotting = true; int minute = 0;
        int freshOranges = numberOfFreshOranges(grid), newRotten = 0;
        
        while(rotting)
        {
            rotting = false;
            for(int i=0;i<grid.length;i++)
            {
                for(int j=0;j<grid[0].length;j++)
                {
                    if(grid[i][j]==1)
                    {
                        if(isValidIndex(i+1,j,grid.length,grid[0].length) && grid[i+1][j]==2)
                        {
                            grid[i][j] = 3;
                            newRotten++;
                            rotting = true;
                        }
                        else if(isValidIndex(i-1,j,grid.length,grid[0].length) && grid[i-1][j]==2)
                        {
                            grid[i][j] = 3;
                            newRotten++;
                            rotting = true;
                        }
                        else if(isValidIndex(i,j+1,grid.length,grid[0].length) && grid[i][j+1]==2)
                        {
                            grid[i][j] = 3;
                            newRotten++;
                            rotting = true;
                        }
                        else if(isValidIndex(i,j-1,grid.length,grid[0].length) && grid[i][j-1]==2)
                        {
                            grid[i][j] = 3;
                            newRotten++;
                            rotting = true;
                        }
                    }
                }
            }
            if(rotting == false)
            {
                if(newRotten != freshOranges)
                {
                    return -1;
                }
                return minute;
            }
            for(int i=0;i<grid.length;i++)
            {
                for(int j=0;j<grid[0].length;j++)
                {
                    if(grid[i][j]==3)
                    {
                        grid[i][j]=2;
                    }
                }
            }
            minute++;
        }
        return minute;
    }
    
    private int numberOfFreshOranges(int[][] grid)
    {
        int count = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean isValidIndex(int i, int j, int maxI, int maxJ)
    {
        if(i>=maxI || i<0 || j>=maxJ || j<0)
        {
            return false;
        }
        return true;
    }
}