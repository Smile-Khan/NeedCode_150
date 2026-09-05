public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
        {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs)
        {
            // Sort the string characters to form the hash map key
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            // Group the original string under its canonical key
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}