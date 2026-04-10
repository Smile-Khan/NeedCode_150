class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums)
        {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Create buckets where index = frequency
        List<Integer>[] buckets = new List[nums.length + 1];
        for(int i = 0; i < buckets.length; i++)
        {
            buckets[i] = new ArrayList<>();
        }

        // Step 3: Fill buckets
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet())
        {
            int number = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].add(number);
        }
        // Collect top k from highest frequency buckets
        int[] result = new int[k];
        int index = 0;

        for(int i = buckets.length - 1; i >= 0 && index < k; i--)
        {
            for(int num : buckets[i])
            {
                result[index++] = num;
                if(index == k) break;
            }
        }
        return result;
    }
}
