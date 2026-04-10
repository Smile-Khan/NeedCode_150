class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Base case
        if(strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for(String word : strs)
        {
            // Sort the characters to get the key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Add to appropriate group
            anagramGroups.putIfAbsent(key, new ArrayList<>());
            anagramGroups.get(key).add(word);
        }
        return new ArrayList<>(anagramGroups.values());
    }
}
