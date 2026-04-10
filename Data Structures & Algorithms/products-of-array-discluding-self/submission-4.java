class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // First pass: compute prefix products
        int prefix = 1;
        for(int i = 0; i < n; i++)
        {
            result[i] = prefix;
            prefix *= nums[i];
        }

        // Second pass: Multiply by suffix products 
        int suffix = 1;
        for(int i = n - 1; i >= 0; i--)
        {
            result[i] *= suffix;
            suffix *= nums[i];
        }
        return result;
    }
}  
