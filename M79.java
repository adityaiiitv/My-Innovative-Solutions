class Solution {
    Set<String> set;
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(iterate(board, word, 0, i, j))
                {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean iterate(char[][] board, String word, int pos, int i, int j)
    {
        if(pos==word.length())
        {
            return true;
        }
        if(i<0 || i==board.length || j<0 || j==board[0].length)
        {
            return false;
        }
        if(board[i][j]!=word.charAt(pos))
        {
            return false;
        }
        board[i][j] ^= 256;
        boolean result = iterate(board, word, pos+1, i+1, j) || iterate(board, word, pos+1, i-1, j)
                        || iterate(board, word, pos+1, i, j+1) || iterate(board, word, pos+1, i, j-1);
        board[i][j] ^=256;
        return result;
    }
}