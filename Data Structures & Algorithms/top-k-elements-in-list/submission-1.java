class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums)
        {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min-heap of size k
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        // Step 3: Add entries to heap, keep size k
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet())
        {
            minHeap.offer(entry);
            if(minHeap.size() > k)
            {
                minHeap.poll(); // Remove least frequent
            }
        }

        // Step 4: Extract from heap
        int[] result = new int[k];
        int index = 0;
        while(!minHeap.isEmpty())
        {
            result[index++] = minHeap.poll().getKey();
        }
        return result;
    }
}
