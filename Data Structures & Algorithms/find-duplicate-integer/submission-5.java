class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Find the intersection point in the cycle
        int slow = nums[0];
        int fast = nums[0];

        do
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);

        // Phase 2: Find the entrance to the cycle (the duplicate numbers)
        slow = nums[0];
        while(slow != fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
