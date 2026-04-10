class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs)
        {
            int[] freq = new int[26];
            for(char ch : s.toCharArray())
            {
                freq[ch - 'a']++;
            }

            // Build key string
            StringBuilder keyBuilder = new StringBuilder();
            for(int i = 0; i < 26; i++)
            {
                if(freq[i] > 0)
                {
                    keyBuilder.append(freq[i]).append((char)('a' + i));
                }
            }
            String key = keyBuilder.toString();

            // Group by this key
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
