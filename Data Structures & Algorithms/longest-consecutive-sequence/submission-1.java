class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        // Step 1: Add all elements to a HashSet for O(1) lookups
        Set<Integer> numSet = new HashSet<>();

        for(int num : nums)
        {
            numSet.add(num);
        }

        int maxLength = 0;

        // Step2: Traverse elements in the set

        for(int num : numSet)
        {
            // Check if 'num' is the START of a sequence

            if(!numSet.contains(num - 1))
            {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers forward
                while(numSet.contains(currentNum + 1))
                {
                    currentNum++;
                    currentStreak++;
                }
                // Update global maximum
                maxLength = Math.max(maxLength, currentStreak);
            }
        }
        return maxLength;
    }
}
