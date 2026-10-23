class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for(int pile : piles)
        {
            high = Math.max(high, pile);
        }
        int ans = high;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(canEatInTime(piles, mid, h))
            {
                ans = mid;  // Try to find a smaller valid speed
                high = mid - 1;
            }
            else 
            {
                low = mid + 1;  // Too slow, need a higher speed
            }
        }
        return ans;
    }
    private boolean canEatInTime(int[] piles, int k, int h)
    {
        long totalHours = 0;
        for(int pile : piles)
        {
            // Equivalent to Math.ceil((double) pile / k) without precision issues
            totalHours += (pile + k - 1) / k;
        }
        return totalHours <= h;
    }
}
