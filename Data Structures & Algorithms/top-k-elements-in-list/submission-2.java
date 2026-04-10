class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequncies using HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : nums)
        {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert map entries to a list
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        // Step 3: Sort by frequency in DESCENDING order
        // (b.getValue() - a.getValue()) gives descending order
        Collections.sort(entryList, (a, b) -> b.getValue() - a.getValue());

        // Step 4: Take first k elements
        int[] result = new int[k];
        for(int i = 0; i < k; i++)
        {
            result[i] = entryList.get(i).getKey();
        }
        return result;
    }
}
