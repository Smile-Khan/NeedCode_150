class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> map = new HashMap<>();

       for(String s : strs)
       {
        // Sort the string to create a key
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);

        // Add to map
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
       }
       return new ArrayList<>(map.values());
    }
}
