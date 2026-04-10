class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k == 0) return new int[0];

        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < n; i++)
        {
            // Remove indices of elements smaller than current from the back
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
            {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Remove indices that are out of current window from the front
            if(deque.peekFirst() <= i - k)
            {
                deque.pollFirst();
            }

            // If window has reached size k, add to result
            if(i >= k - 1)
            {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
