class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Starting from every cell
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(dfs(board, word, 0, i, j))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int index, int i, int j)
    {
        // Base case: All characters matched
        if(index == word.length())
        {
            return true;
        }

        // Boundary checks
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
        {
            return false;
        }


        // Character doesn't match OR already visited
        if(board[i][j]  != word.charAt(index))
        {
            return false;
        }

        // Mark as visited (temporarily modify the board)
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all 4 directions
        boolean found = dfs(board, word, index + 1, i-1, j) ||
                        dfs(board, word, index + 1, i+1, j) ||
                        dfs(board, word, index + 1, i, j-1) ||
                        dfs(board, word, index + 1, i, j+1);

        board[i][j] = temp;

        return found;
     }
}
