class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();

        // Add all numbers to set
        for(int num : nums)
        {
            set.add(num);
        }

        int maxLength = 0;

        // Find sequences
        for(int num : set)
        {
            // Check if this is the start of a sequence
            if(!set.contains(num - 1))
            {
                int currentNum = num;
                int currentLength = 1;

                // Count consecutive numbers
                while(set.contains(currentNum + 1))
                {
                    currentNum++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
