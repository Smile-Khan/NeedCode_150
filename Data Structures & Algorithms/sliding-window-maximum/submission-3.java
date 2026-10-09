class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;

        // Deque stores indices of elemnts
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < n; i++)
        {
            // 1. Remove indices that are out of the current window [i - k + 1, i]
            while(!deque.isEmpty() && deque.peekFirst() < i - k + 1)
            {
                deque.pollFirst();
            }

            // 2. Remove elements from the back that are smaller than the current element
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
            {
                deque.pollFirst();
            }

            // 3. Add current element index to the back
            deque.offerLast(i);

            // 4. Record the maximum for the window once we reach size k
            if(i >= k - 1)
            {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
