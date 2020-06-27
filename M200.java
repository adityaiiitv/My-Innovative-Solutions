class Solution {
    public int numIslands(char[][] grid)
        {
            if (grid.length == 0) 
            {
                return 0;
            }
            int islands = 0;
            for (int i = 0; i < grid.length; i++)
            {
                for (int j = 0; j < grid[0].length; j++)
                {
                    if (grid[i][j] == '1')
                    {
                        markVisited(grid, i, j);
                        islands++;
                    }
                }
            }

            return islands;
        }

        public void markVisited(char[][] grid, int i, int j)
        {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
                return;
            if (grid[i][j] == '1')
            {
                grid[i][j] = '0';
                markVisited(grid, i - 1, j);
                markVisited(grid, i, j - 1);
                markVisited(grid, i, j + 1);
                markVisited(grid, i + 1, j);
            }
        }
}