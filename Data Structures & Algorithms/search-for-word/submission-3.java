class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(dfs(board, word, visited, i, j, 0))
                {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index)
    {
        if(index == word.length())
        {
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
           visited[i][j] || board[i][j] != word.charAt(index))
           {
            return false;
           }

        visited[i][j] = true;

        boolean found = dfs(board, word, visited, i + 1, j, index + 1) ||
                        dfs(board, word, visited, i - 1, j, index + 1) ||
                        dfs(board, word, visited, i, j + 1, index + 1) ||
                        dfs(board, word, visited, i, j - 1, index + 1);
        
        visited[i][j] = false;

        return found;
    }
}
