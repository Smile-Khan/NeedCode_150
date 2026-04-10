class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while(left < right)
        {
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right])
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }
        int pivot = left;

        // Determine which half to search
        if(target >= nums[pivot] && target <= nums[n - 1])
        {
            left = pivot;
            right = n - 1;
        }
        else
        {
            left = 0;
            right = pivot - 1;
        }
        

        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return -1;
    }
}
