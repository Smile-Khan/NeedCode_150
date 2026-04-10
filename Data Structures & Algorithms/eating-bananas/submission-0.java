class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        // Find maximum pile (upper bound for eating speed)
        for(int pile : piles)
        {
            right = Math.max(right, pile);
        }

        while(left < right)
        {
            int mid = left + (right - left) / 2;

            if(canEatAll(piles, mid, h))
            {
                right = mid;    // Try slower speed
            }
            else

            {
                left = mid + 1; // Need faster speed
            }
        }
        return left;
    }
    private boolean canEatAll(int[] piles, int speed, int h)
    {
        long hours = 0; // Use long to prevent overflow

        for(int pile : piles)
        {
             // Hours for this pile = ceil(pile / speed)
             hours += (pile + speed - 1) / speed;

             if(hours > h)
             {
                return false;// early exit
             }
        }
        return hours <= h;
    }
}
