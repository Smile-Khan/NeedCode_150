class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
        {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int half = (total + 1) / 2;

        int left = 0;
        int right = m;

        while(left <= right)
        {
            int i = left + (right - left) / 2;
            int j = half - i;   // partition in nums2

            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if(nums1Left <= nums2Right && nums2Left <= nums1Right)
            {
                // Valid partition found
                if(total % 2 == 1)
                {
                    return Math.max(nums1Left, nums2Left);
                }
                else
                {
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                }
            }
            else if(nums1Left > nums2Right)
            {
                // Need to move partition left in nums1
                right = i - 1;
            }
            else
            {
                // Need to move partition right in nums1
                left = i + 1;
            }
        }
        return 0.0;
    }
}
