public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map stores vavlues -> original index
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            int complement = target - nums[i];

            // If compliment exists in map, we found our pair
            if(seen.containsKey(complement))
            {
                return new int[]{seen.get(complement), i};
            }

            // Otherwise, record current value and its index
            seen.put(nums[i], i);
        }
        return new int[]{};
    }
}