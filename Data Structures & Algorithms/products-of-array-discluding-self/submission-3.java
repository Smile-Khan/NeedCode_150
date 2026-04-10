class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Calculate total product and count zeros
        int totalProduct = 1;
        int zeroCount = 0;
        int zeroIndex = -1;

        for(int i = 0; i < n; i++)
        {
            if(nums[i] == 0)
            {
                zeroCount++;
                zeroIndex = i;
            }
            else
            {
                totalProduct *= nums[i];
            }
        }

        // Case 1: More than one zero
        if(zeroCount > 1)
        {
            return result;
        }

        // Case 2: Exactly one zero
        if(zeroCount == 1)
        {
            result[zeroIndex] = totalProduct;
            return result;
        }

        // Case 3: No zeros
        for(int i = 0; i < n; i++)
        {
            result[i] = totalProduct / nums[i];
        }
        return result;
    }
}  
