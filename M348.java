class TicTacToe {

    /** Initialize your data structure here. */
    int dimension;
    int moves;
    char[][] board;
    public TicTacToe(int n) {
        dimension = n;
        moves = 0;
        board = new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j] = 'A';
            }
        }
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        char[][] b = board;
        if(player==1)
        {
            board[row][col] = 'X';    
        }
        else{
            board[row][col] = 'O';
        }
        moves++;
        if(moves<dimension)
        {
            return 0; 
        }
        else{
            int count = 0;
            for(int i=0;i<dimension;i++)
            {
                if(board[i][col]==board[row][col])
                {
                    count++;
                }
            }
            if(count==dimension) return player;
            count = 0;
            for(int i=0;i<dimension;i++)
            {
                if(board[row][i]==board[row][col])
                {
                    count++;
                }
            }
            if(count==dimension) return player;
            if(row==col)
            {
                count = 0;
                for(int i=0;i<dimension;i++)
                {
                    if(board[i][i]==board[row][col])
                    {
                        count++;
                    }
                }
                if(count==dimension) return player;
            }
            if(row+col+1==dimension)
            {
                count = 0;
                for(int i=0;i<dimension;i++)
                {
                    if(board[dimension-i-1][i]==board[row][col])
                    {
                        count++;
                    }
                }
                if(count==dimension) return player;
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */