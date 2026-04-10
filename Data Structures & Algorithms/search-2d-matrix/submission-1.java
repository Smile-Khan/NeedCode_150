class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        while(left <= right)
        {
            int mid = left + (right - left) / 2;

            // Convert mid index to 2D cordinates
            int row = mid / n;  // Row = mid / number of columns
            int col = mid % n;  // Column = mid % number of columns

            if(matrix[row][col] == target)
            {
                return true;
            }
            else if(matrix[row][col] < target)
            {
                left = mid + 1;
            }
            else 
            {
                right = mid - 1;
            }
        }
        return false;
    }
}
