class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left < right)
        {
            int sum = numbers[left] + numbers[right];

            if(sum == target)
            {
                // Return 1-indexed indices
                return new int[]{left + 1, right + 1};
            }
            else if(sum < target)
            {
                // Need larger sum, move left pointer right
                left++;
            }
            else
            {
                // Need smaller sum, move right pointer left
                right--;
            }
        }
        // Problem guarantees a solution exists, so we shouldn't reach here
        return new int[]{-1,-1};
    }
}
