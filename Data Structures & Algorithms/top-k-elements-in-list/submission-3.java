
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count element frequencies
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets where index = frequency
        // buckets[f] contains all elements that appear 'f' times
        List<Integer>[] buckets = new List[nums.length + 1];
        
        for (int num : countMap.keySet()) {
            int freq = countMap.get(num);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        // Step 3: Iterate from highest bucket down to lowest to get top K elements
        int[] result = new int[k];
        int idx = 0;

        for (int freq = buckets.length - 1; freq >= 1 && idx < k; freq--) {
            if (buckets[freq] != null) {
                for (int num : buckets[freq]) {
                    result[idx++] = num;
                    if (idx == k) break;
                }
            }
        }

        return result;
    }
}