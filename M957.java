class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(cells.length ==0)
        {
            return cells;
        }
        boolean hasCycle = false;
        int cycles = 0;
        Set<String> set = new HashSet<>();
        String temp;
        for(int i=0;i<N;i++)
        {
            int[] next = nextDay(cells);
            temp = Arrays.toString(next);
            if(!set.contains(temp))
            {
                set.add(temp);
                cycles++;
            }
            else{
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if(hasCycle)
        {
            N%=cycles;
            for(int i=0;i<N;i++)
            {
                cells = nextDay(cells);
            }
        }
        return cells;
    }
    
    private int[] nextDay(int[] cells)
    {
        int[] today = new int[cells.length];
        for(int i=1;i<cells.length-1;i++)
        {
            today[i] = cells[i-1]==cells[i+1] ? 1 : 0;
        }
        return today;
    }
}