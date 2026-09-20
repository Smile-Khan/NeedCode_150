class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++)
        {
            int left = i + 1;
            int right = numbers.length - 1;

            int temp = target - numbers[i];
            while(left <= right)
            {
                int mid = left + (right - left) / 2;

                if(numbers[mid] == temp)
                {
                    return new int[] {i + 1, mid + 1};

                }
                else if(numbers[mid] < temp)
                {
                    left = mid + 1;
                }
                else 
                {
                    right = mid - 1;
                }
            }
        }
        return new int[0];
    }
}
