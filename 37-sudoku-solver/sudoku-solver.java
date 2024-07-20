class Solution {
    //Method given in LeetCode
    //Given in Constraint that "It is guaranteed that the input board has only one solution".
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    //Method to Solve
    private boolean solve(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (valid(board, i, j, k)) {
                            board[i][j]= k;
                            if (solve(board))
                                return true;
                            else
                                board[i][j]='.'; //Most IMP Step (Backtracking)
                        }
                    }
                    //'1' to '9' characters are not valid means it's not possible because of previous character allotment so
                    return false;
                }
            }
        }
        //Each row and col checked successfully and now every index is assigned i.e. '.' is not there in any index so
        return true;
    }

    //Method to check whether a character can be assigned or not.
    private boolean valid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            //Checking in the row
            if (board[row][i] == c)
                return false;

            //Checking in the column
            if (board[i][col] == c)
                return false;

            //Checking in the 3 X 3 Matrix
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }
}